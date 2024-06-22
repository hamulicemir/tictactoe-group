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
        game.getBoard().place(0, 0, 'X'); // Füge einen Zug hinzu, um den Reset zu testen
    }

    @Test
    public void testStartNewGame() {
        game.start();
        char[][] board = game.getBoard().getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('\0', board[i][j]);
            }
        }
    }

    @Test
    public void testPlayersRemainSameAfterNewGame() {
        Player player1 = game.getCurrentPlayer();
        game.start();
        assertEquals(player1, game.getCurrentPlayer());
    }

}