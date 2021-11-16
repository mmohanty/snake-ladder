package com.example.snakeladder.service;

import com.example.snakeladder.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSnakeLadderServiceImpl {

    private SnakeLadderService snakeLadderService;


    @BeforeEach
    public void setup(){
        snakeLadderService = new SnakeLadderServiceImpl();
    }

    private void createPlayers(Board board) {
        Player player1 = new Player("X1", 0, false, 0);
        Player player2 = new Player("X2", 0, false, 0);
        Player player3 = new Player("X3", 0, false, 0);
        Player player4 = new Player("X4", 0, false, 0);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        board.setPlayers(playerList);
    }

    private BoardConfig createBoardConfig() {
        BoardConfig boardConfig = new BoardConfig();
        Map<Integer, PlayerCarrier> playerCarrierMap = new HashMap<>();
        playerCarrierMap.put(10, new PlayerCarrier(5,  CarrierType.LADDER));
        playerCarrierMap.put(30, new PlayerCarrier(8,  CarrierType.LADDER));
        playerCarrierMap.put(70, new PlayerCarrier(10,  CarrierType.LADDER));
        playerCarrierMap.put(15, new PlayerCarrier(5,  CarrierType.SNAKE));
        playerCarrierMap.put(25, new PlayerCarrier(5,  CarrierType.SNAKE));
        playerCarrierMap.put(35, new PlayerCarrier(5,  CarrierType.SNAKE));
        boardConfig.setPlayerCarrierMap(playerCarrierMap);
        return boardConfig;
    }

    @Test
    public void testPlayGame(){
        Board board = snakeLadderService.initializeBoard(createBoardConfig());
        createPlayers(board);
        while(board.getWinner() == null){
            snakeLadderService.rollDice(board);
        }
        Assertions.assertNotNull(snakeLadderService.getWinner(board));
        Assertions.assertEquals(snakeLadderService.getWinner(board).getCurrentPosition(), 100);
    }
}
