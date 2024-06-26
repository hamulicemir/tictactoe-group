package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '\0';
    }

    public char[][] getCells() {
        return cells;
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '\0';
            }
        }
    }
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                sb.append(cells[i][j] == '\0' ? " " : cells[i][j]);
                if (j < cells[i].length - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < cells.length - 1) {
                sb.append("-----\n");
            }
        }
        return sb.toString();
    }
    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
