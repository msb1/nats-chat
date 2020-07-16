package com.demo.nats.natmsggen.repository;

import com.demo.nats.natmsggen.model.SportExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionRepository extends JpaRepository<SportExecution, Long> {
}
