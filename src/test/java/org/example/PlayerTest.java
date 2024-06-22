package org.example;
import org.junit.*;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class PlayerTest {
    private Player playerX;
    private Player playerO;

    @Before
    public void setUp() {
        playerX = new Player('X');
        playerO = new Player('O');
    }

    @Test
    public void testGetMarkerForPlayerX() {
        // Positiver Test: Überprüft, ob der Marker korrekt für Spieler X gesetzt wird.
        assertEquals('X', playerX.getMarker());
    }

    @Test
    public void testGetMarkerForPlayerO() {
        // Positiver Test: Überprüft, ob der Marker korrekt für Spieler O gesetzt wird.
        assertEquals('O', playerO.getMarker());
    }

    @Test
    public void testInvalidMarker() {
        // Negativer Test: Überprüft, ob ein ungültiger Marker (z.B. ein Zahlenwert) korrekt gesetzt wird.
        Player invalidPlayer = new Player('1');
        assertEquals('1', invalidPlayer.getMarker());
    }

    @Test
    public void testEmptyMarker() {
        // Negativer Test: Überprüft, ob ein ungültiger leerer Marker ('\0') korrekt gesetzt wird.
        Player emptyPlayer = new Player('\0');
        assertEquals('\0', emptyPlayer.getMarker());
    }

}