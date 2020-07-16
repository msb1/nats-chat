package com.demo.chat.repository;

import com.demo.chat.model.SportEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ReactiveMongoRepository<SportEvent, Long> {
}
