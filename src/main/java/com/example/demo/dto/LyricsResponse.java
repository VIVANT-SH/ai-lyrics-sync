package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LyricsResponse {

    private String title;
    private String artist;
    private String lyrics;
}
