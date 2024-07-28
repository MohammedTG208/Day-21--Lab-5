package com.example.week5lab1event.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EvenSystem {
//    ID , description , capacity, startDate , endDate
    private int id;
    private String description;
    private double capacity;
    private LocalDate startDate;
    private LocalDate endDate;
}
