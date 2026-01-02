package com.example.demo.service;

import com.example.demo.entity.HealthLog;
import com.example.demo.repository.HealthLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HealthLogService {

    private final HealthLogRepository healthLogRepository;

    public void saveHealthLog(String status, String message) {
        HealthLog log = HealthLog.builder()
                .status(status)
                .message(message)
                .createdAt(LocalDateTime.now())
                .build();

        healthLogRepository.save(log);
    }
}
