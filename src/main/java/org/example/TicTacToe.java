package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != '\0' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (cells[0][j] != '\0' && cells[0][j] == cells[1][j] && cells[1][j] == cells[2][j]) {
                return true;
            }
        }
        if (cells[0][0] != '\0' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return true;
        }
        if (cells[0][2] != '\0' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return true;
        }
        return false;
    }
    public Board getBoard(){
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
