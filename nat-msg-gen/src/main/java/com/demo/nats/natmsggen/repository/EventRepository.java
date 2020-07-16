package com.demo.nats.natmsggen.repository;

import com.demo.nats.natmsggen.model.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<SportEvent, Long> {
}
