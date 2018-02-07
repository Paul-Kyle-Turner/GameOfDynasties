package com.company;

import java.util.Random;
import java.lang.Math;

public class Board {

    private final int ALIVE = 1;
    private final int DEAD = 0;

    private boolean mod = false;

    private Life[][] board;

    public Board(){
        this.board = new Life[20 + 2][60 + 2];
        initBoard(this.board);
    }

    public Board(int numb_row, int numb_col){
        this.board = new Life[numb_row + 2][numb_col + 2];
        initBoard(this.board);
    }

    private static void initBoard(Life[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = new Life(i,j,0);
            }
        }
    }

    private boolean violateRules(int x, int y){
        if(x == 0 || x == board.length || y == 0 || y == board[0].length){
            return false;
        }
        return true;
    }

    public void randomize(){
        Random rand = new Random();
        int squares = this.board.length * this.board[0].length;
        for(int i = (int) Math.floor(squares * rand.nextDouble()); i < squares; i++){
            int x = (int) (board.length * rand.nextDouble());
            int y = (int) (board[0].length * rand.nextDouble());
            if(this.violateRules(x,y)){

            }
            else if(!board[x][y].is_alive()){
                board[x][y].setValue(ALIVE);
            }
        }
    }

    public void makeLife(int x, int y){
        this.board[x][y].setValue(ALIVE);
    }

    public void updateBoard(boolean mod){
        if(mod){
            updateBoardModified();
        }
        else{
            updateBoardUnmodified();
        }
    }

    public void updateBoardModified(){
        Life[][] new_board = new Life[board.length][board[0].length];
        initBoard(new_board);
        for(int i = 1; i < board.length - 2; i++) {
            for (int j = 1; j < board[0].length - 2; j++) {
                switch (adjacent_life(i, j)) {
                    case 2:
                    case 3:
                        new_board[i][j].setValue(ALIVE);
                        break;
                    default:
                        new_board[i][j].setValue(DEAD);
                        break;
                }
            }
        }
        this.board = new_board;
    }

    public void updateBoardUnmodified(){
        Life[][] new_board = new Life[board.length][board[0].length];
        initBoard(new_board);
        for(int i = 1; i < board.length - 2; i++) {
            for (int j = 1; j < board[0].length - 2; j++) {
                switch (adjacent_life(i, j)) {
                    case 2:
                        new_board[i][j] = this.board[i][j];
                        break;
                    case 3:
                        new_board[i][j].setValue(ALIVE);
                        break;
                    default:
                        new_board[i][j].setValue(DEAD);
                        break;
                }
            }
        }
        this.board = new_board;
    }

    public void updateBoardMany(int n, boolean mod){
        for(int i = 0; i < n; i++){
            this.updateBoard(mod);
        }
    }

    private int adjacent_life(int numb_row, int numb_col){
        int count = 0;
        for(int i = numb_row - 1, i2 = i + 2; i <= i2; i++){
            for(int j = numb_col - 1, j2 = j + 2; j <= j2; j++){
                if(i == numb_row && j == numb_col){ }
                else if(board[i][j].is_alive()){
                    count++;
                }
            }
        }
        return count;
    }

    public String printOpen(){
        String open = "Welcome to the game of life!\n";
        return open;
    }

    @Override
    public String toString() {
        String print = "";
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j == board[0].length - 1){
                    print += "*\n";
                }
                else if(i == 0 || j == 0 || i == board.length-1) {
                    print += "*";
                }
                else{
                    print += board[i][j].toString();
                }
            }
        }
        return print;
    }

}
