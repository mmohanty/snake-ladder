package com.example.snakeladder.service;

import com.example.snakeladder.model.Board;
import com.example.snakeladder.model.BoardConfig;
import com.example.snakeladder.model.Player;

public interface SnakeLadderService {

    void rollDice(final Board board);
    Player getWinner(final Board board);
    Board initializeBoard(BoardConfig boardConfig);
    void registerPlayer(Board board, Player player);
}
