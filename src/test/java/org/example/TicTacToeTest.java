package org.example;
import org.junit.*;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
        game.start();
    }
    @Test
    public void testStart() {
        game.start();
        Board board = game.getBoard();
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('\0', cells[i][j]);
            }
        }
    }

    @Test
    public void testHasWinner_NoWinnerAtStart() {
        game.start();
        assertFalse(game.hasWinner());
    }

    @Test
    public void testHasWinner_RowWinner() {
        game.start();
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[0][1] = 'X';
        cells[0][2] = 'X';
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinner_ColumnWinner() {
        game.start();
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'O';
        cells[1][0] = 'O';
        cells[2][0] = 'O';
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinner_DiagonalWinner() {
        game.start();
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[1][1] = 'X';
        cells[2][2] = 'X';
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinner_ReverseDiagonalWinner() {
        game.start();
        char[][] cells = game.getBoard().getCells();
        cells[0][2] = 'O';
        cells[1][1] = 'O';
        cells[2][0] = 'O';
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinner_NoWinner() {
        game.start();
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[0][1] = 'O';
        cells[0][2] = 'X';
        cells[1][0] = 'O';
        cells[1][1] = 'X';
        cells[1][2] = 'O';
        cells[2][0] = 'O';
        cells[2][1] = 'X';
        cells[2][2] = 'O';
        assertFalse(game.hasWinner());
    }

    @Test
    public void testHasWinner_NoWinnerWithPartialFilling() {
        game.start();
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[0][1] = 'O';
        cells[0][2] = 'X';
        cells[1][0] = 'O';
        cells[1][1] = 'X';
        // Restliche Felder bleiben leer
        assertFalse(game.hasWinner());
    }


}