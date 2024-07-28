package com.example.week5lab1tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
