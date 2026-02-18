package br.com.sudoku.service;

import br.com.sudoku.model.Board;
import br.com.sudoku.model.GameStatusEnum;
import br.com.sudoku.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {

    private static final int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(final Map<String, String> gameConfig) {
        board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces(){
        return board.getSpaces();
    }

    public void reset(){
        this.board.reset();
    }

    public boolean hasErrors(){
        return board.hasErrors();
    }

    public GameStatusEnum getStatus(){
        return board.getStatus();
    }

    public boolean gameIsFinished(){
        return board.gameIsFinished();
    }

    private List<List<Space>> initBoard(Map<String, String> gameConfig) {
        List<List<Space>> spaces = new ArrayList();
        for(int i = 0; i < 9; ++i) {
            spaces.add(new ArrayList());
            for(int j = 0; j < 9; ++j) {
                String positionConfig = (String)gameConfig.get("%s,%s".formatted(i, j));
                int expected = Integer.parseInt(positionConfig.split(",")[0]);
                boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                Space currentSpace = new Space(expected, fixed);
                ((List)spaces.get(i)).add(currentSpace);
            }
        }

        return spaces;
    }
}
