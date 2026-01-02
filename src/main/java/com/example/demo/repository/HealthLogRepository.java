package com.example.demo.repository;

import com.example.demo.entity.HealthLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthLogRepository extends JpaRepository<HealthLog, Long> {
    Optional<HealthLog> findTopByOrderByCreatedAtDesc();
}
