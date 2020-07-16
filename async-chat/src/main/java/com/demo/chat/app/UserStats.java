package com.demo.chat.app;

import com.demo.chat.model.Chat;
import com.demo.chat.repository.ChatRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class UserStats {

    UnicastProcessor<ChatEvent> eventPublisher;
    ConcurrentHashMap<String, Stats> userStatsMap = new ConcurrentHashMap<>();

    // Any chat user can filter event/execution message push by checking filter on sign in
    private final static AtomicInteger filterCounter = new AtomicInteger(0);

    public static boolean filterNats() {
        return filterCounter.get() > 0;
    }

    public UserStats(Flux<ChatEvent> events, UnicastProcessor<ChatEvent> eventPublisher, ChatRepository chatRepository) {
        this.eventPublisher = eventPublisher;

        events.map(ev -> {
            Chat chat = new Chat(ev.getType(), ev.getUser().getAlias(), ev.getTimestamp(), ev.getPayload().getProperties());
            chatRepository.save(chat).subscribe();
            return ev;
        })
                .filter(type(ChatEvent.Type.CHAT_MESSAGE, ChatEvent.Type.USER_JOINED))
                .subscribe(this::onChatMessage);

        events.filter(type(ChatEvent.Type.USER_LEFT))
                .map(ChatEvent::getUser)
                .map(user -> {
                    if (user.isFilter()) filterCounter.decrementAndGet();
                    return user.getAlias();
                })
                //.map(User::getAlias)
                .subscribe(userStatsMap::remove);

        events.filter(type(ChatEvent.Type.USER_JOINED))
                .map(event -> {
                    if (event.getUser().isFilter()) filterCounter.incrementAndGet();
                    return event;
                })
                .map(event -> ChatEvent.type(ChatEvent.Type.USER_STATS)
                        .withPayload()
                        .systemUser()
                        .property("stats", new HashMap<>(userStatsMap))
                        .build()
                )
                .subscribe(eventPublisher::onNext);
    }

    private static Predicate<ChatEvent> type(ChatEvent.Type... types) {
        return event -> asList(types).contains(event.getType());
    }

    private void onChatMessage(ChatEvent event) {
        String alias = event.getUser().getAlias();
        Stats stats = userStatsMap.computeIfAbsent(alias, s -> new Stats(event.getUser()));
        stats.onChatMessage(event);
    }

    private static class Stats {
        private final User user;
        private long lastMessage;
        private final AtomicInteger messageCount = new AtomicInteger();

        public Stats(User user) {
            this.user = user;
        }

        public void onChatMessage(ChatEvent event) {
            lastMessage = event.getTimestamp();
            if (ChatEvent.Type.CHAT_MESSAGE == event.getType()) messageCount.incrementAndGet();
        }

        public User getUser() {
            return user;
        }

        public long getLastMessage() {
            return lastMessage;
        }

        public int getMessageCount() {
            return messageCount.get();
        }
    }
}
