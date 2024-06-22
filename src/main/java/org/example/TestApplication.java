package org.example;

import java.util.Scanner;

public class TestApplication {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        game.start();
        while (true) {
            System.out.println("Current board:");
            System.out.println(game.getBoard().print());

            if (game.hasWinner()) {
                game.switchCurrentPlayer();
                System.out.println("Player " + game.getCurrentPlayer().getMarker() + " wins!");
                break;
            }

            if (game.getBoard().isFull()) {
                System.out.println("The game is a tie!");
                break;
            }

            System.out.println("Player " + game.getCurrentPlayer().getMarker() + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!game.getBoard().place(row, col, game.getCurrentPlayer().getMarker())) {
                System.out.println("This move is not valid");
            } else {
                game.switchCurrentPlayer();
            }
        }

        System.out.println("Final board:");
        System.out.println(game.getBoard().print());
        scanner.close();
    }
}