package com.example.snakeladder.model;

import lombok.Data;

import java.util.List;

@Data
public class Board {

    public Board (int startNumber, int endNumber){
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public Board (){
        this.startNumber = 1;
        this.endNumber = 100;
    }
    private int currentPlayerIndex;
    private List<Player> players;
    private BoardConfig boardConfig;
    private BoardStatus boardStatus;
    private Player winner;
    private int endNumber;
    private int startNumber;


}
