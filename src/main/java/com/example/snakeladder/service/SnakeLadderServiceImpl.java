package com.example.snakeladder.service;

import com.example.snakeladder.exception.InvalidConfigurationException;
import com.example.snakeladder.model.*;
import com.example.snakeladder.util.DiceUtil;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderServiceImpl implements SnakeLadderService {

    @Override
    public Board initializeBoard(BoardConfig boardConfig) {
        Board board = new Board();
        board.setCurrentPlayerIndex(-1);
        board.setBoardStatus(BoardStatus.WAITING);
        addCarrierToBoard(board, boardConfig);
        return board;
    }

    private void addCarrierToBoard(Board board, BoardConfig boardConfig) {
        if(boardConfig == null){
            throw new InvalidConfigurationException("Board configuration is missing");
        }
        board.setBoardConfig(boardConfig);
    }

    @Override
    public void registerPlayer(Board board, Player player) {
        if(board == null || player == null){
            throw new InvalidConfigurationException("Board or Player can not be null");
        }
        List<Player> players = board.getPlayers() == null ? new ArrayList<>(): board.getPlayers();
        if(players.size() == 0){
            board.setPlayers(players);
            board.setCurrentPlayerIndex(0);
        }
        players.add(player);
    }


    @Override
    public void rollDice(final Board board) {
        int number = DiceUtil.getNextNumber(6);
        if(board.getCurrentPlayerIndex() == board.getPlayers().size() || board.getCurrentPlayerIndex() == -1){
            board.setCurrentPlayerIndex(0);
        }
        Player currentPlayer = board.getPlayers().get(board.getCurrentPlayerIndex());
        int nextPositionOfPlayer = currentPlayer.getCurrentPosition() + number;
        decideNextMove(board, number, currentPlayer, nextPositionOfPlayer);

    }

    private void decideNextMove(Board board, int number, Player currentPlayer, int nextPositionOfPlayer) {
        int indexOfPlayer = board.getCurrentPlayerIndex();
        if(nextPositionOfPlayer == board.getEndNumber()){
            //Decide Winner
            board.setBoardStatus(BoardStatus.WINNER_DECIDED);
            board.setWinner(currentPlayer);
        }else if(currentPlayer.getConsecutiveSixes() == 1 && number == 6){
            //dont move player
            board.setCurrentPlayerIndex(indexOfPlayer+1);
        }else if(currentPlayer.getConsecutiveSixes() == 0 && number == 6) {
            //give another chance to player
            movePlayer(currentPlayer, nextPositionOfPlayer, number, board);
        }else{
            movePlayer(currentPlayer, nextPositionOfPlayer, number, board);
            board.setCurrentPlayerIndex(indexOfPlayer+1);
        }

    }

    private void movePlayer(Player currentPlayer, int nextPositionOfPlayer, int number, Board board) {
        int finalPosition;
        if(board.getBoardConfig().getPlayerCarrierMap().containsKey(nextPositionOfPlayer)){
            PlayerCarrier playerCarrier = board.getBoardConfig().getPlayerCarrierMap().get(nextPositionOfPlayer);
            finalPosition = playerCarrier.getCarrierType().nextPosition(nextPositionOfPlayer, playerCarrier.getOffset());

        }else{
            finalPosition = nextPositionOfPlayer;
        }
        currentPlayer.setCurrentPosition(finalPosition);

    }

    @Override
    public Player getWinner(final Board board) {
        if(board.getBoardStatus() == BoardStatus.WINNER_DECIDED){
            return board.getWinner();
        }else{
            return null;
        }
    }

}
