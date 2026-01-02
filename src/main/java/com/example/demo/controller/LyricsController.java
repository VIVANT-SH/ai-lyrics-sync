package com.example.demo.controller;

import com.example.demo.dto.LyricsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LyricsController {

    @GetMapping("/lyrics/sample")
    public LyricsResponse sampleLyrics() {
        return new LyricsResponse(
                "夜に駆ける",
                "YOASOBI",
                "沈むように溶けてゆくように…"
        );
    }
}
