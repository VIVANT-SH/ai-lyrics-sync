package com.example.demo.service;

import com.example.demo.dto.HealthLogResponse;
import com.example.demo.entity.HealthLog;
import com.example.demo.repository.HealthLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final HealthLogRepository healthLogRepository;

    @PostConstruct
    public void init() {
        saveLog("OK", "service layer is working");
    }

    // 로그 저장
    public HealthLogResponse saveLog(String status, String message) {
        HealthLog log = new HealthLog();
        log.setStatus(status);
        log.setMessage(message);
        log.setCreatedAt(LocalDateTime.now());

        HealthLog saved = healthLogRepository.save(log);
        return new HealthLogResponse(saved.getId(), saved.getStatus(), saved.getMessage(), saved.getCreatedAt());
    }

    // 전체 조회
    public List<HealthLogResponse> getAllLogs() {
        return healthLogRepository.findAll()
                .stream()
                .map(log -> new HealthLogResponse(log.getId(), log.getStatus(), log.getMessage(), log.getCreatedAt()))
                .collect(Collectors.toList());
    }

    // 최신 1건
    public HealthLogResponse getLatestLog() {
        return healthLogRepository.findTopByOrderByCreatedAtDesc()
                .map(log -> new HealthLogResponse(log.getId(), log.getStatus(), log.getMessage(), log.getCreatedAt()))
                .orElse(null);
    }
}
