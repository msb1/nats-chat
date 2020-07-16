package com.demo.chat.repository;

import com.demo.chat.model.Chat;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<Chat, Long> {
}
