package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "health_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    // <-- 이거 붙여야 .builder() 사용 가능
public class HealthLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String message;
    private LocalDateTime createdAt;
}
