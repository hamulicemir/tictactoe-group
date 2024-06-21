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
    @Test(expected = IndexOutOfBoundsException.class) //Außerhalb vom Spielfeld
    public void testPlaceMarkerOutsideBoard() {
        board.place(3, 3, 'X');
    }
}
