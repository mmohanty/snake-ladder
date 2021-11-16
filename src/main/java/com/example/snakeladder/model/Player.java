package com.example.snakeladder.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String playerShortName;
    private int currentPosition;
    private boolean started;
    private int consecutiveSixes;
}
