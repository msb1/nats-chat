package com.demo.chat.repository;

import com.demo.chat.model.SportExecution;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionRepository extends ReactiveMongoRepository<SportExecution, Long> {
}
