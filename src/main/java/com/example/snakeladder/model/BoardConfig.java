package com.example.snakeladder.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BoardConfig {
    Map<Integer, PlayerCarrier> playerCarrierMap;
}
