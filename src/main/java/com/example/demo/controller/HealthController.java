package com.example.demo.controller;

import com.example.demo.dto.HealthLogRequest;
import com.example.demo.dto.HealthLogResponse;
import com.example.demo.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;

    @GetMapping("/logs")
    public List<HealthLogResponse> getLogs() {
        return healthService.getAllLogs();
    }

    @GetMapping("/logs/latest")
    public HealthLogResponse getLatestLog() {
        return healthService.getLatestLog();
    }

    @PostMapping("/log")
    public HealthLogResponse saveLog(@RequestBody HealthLogRequest request) {
        return healthService.saveLog(request.getStatus(), request.getMessage());
    }
}
