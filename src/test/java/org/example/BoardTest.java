package org.example;
import org.junit.*;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPlaceMarkerOnEmptyCell() {
        boolean success = board.place(0, 0, 'X');
        assertTrue(success); //Prüfung, ob Plazierung auf freiem Feld möglich ist
        assertEquals('X', board.getCells()[0][0]); //Prüfung, ob "X" tatsächlich vorhanden ist.
    }

    @Test
    public void testPlaceMarkerOnOccupiedCell() {
        board.place(0, 0, 'X');
        boolean success = board.place(0, 0, 'O');
        assertFalse(success); //Prüfung, ob auf besetzte Zelle gesetzt werden kann.
        assertEquals('X', board.getCells()[0][0]); //Prüfung, ob die "X" weiterhin vorhanden ist.
    }
    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(1, 1)); // Zelle ist leer
        board.place(1, 1, 'O');
        assertFalse(board.isCellEmpty(1, 1)); // Zelle ist besetzt
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPlaceMarkerOutsideBoard() {
        board.place(3, 3, 'X');
    }
    @Test
    public void testPrintEmptyBoard() {
        String expectedOutput = " | | \n" + "-----\n" + " | | \n" + "-----\n" + " | | \n";
        assertEquals(expectedOutput, board.print());
    }

    @Test
    public void testPrintBoardWithMoves() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        String expectedOutput = "X| | \n" + "-----\n" + " |O| \n" + "-----\n" + " | | \n";
        assertEquals(expectedOutput, board.print());
    }

    @Test
    public void testPrintBoardFull() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'O');
        board.place(2, 1, 'X');
        board.place(2, 2, 'O');
        String expectedOutput = "X|O|X\n" + "-----\n" + "O|X|O\n" + "-----\n" + "O|X|O\n";
        assertEquals(expectedOutput, board.print());
    }
    @Test
    public void testIsFullWhenPartiallyFilled() {
        // Negativer Test: Board ist teilweise gefüllt und sollte nicht voll sein.
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        assertFalse(board.isFull());
    }

    @Test
    public void testIsFullWhenCompletelyFilled() {
        // Positiver Test: Board ist vollständig gefüllt und sollte voll sein.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFullAfterClear() {
        // Negativer Test: Board wird nach vollständiger Füllung gelöscht und sollte nicht voll sein.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.clear();
        assertFalse(board.isFull());
    }


    @Test
    public void testPlace() {
        // Positiver Test: Überprüft, ob die Platzierung korrekt erfolgt.
        board.place(0, 0, 'X');
        assertEquals('X', board.getCells()[0][0]);
    }
}
