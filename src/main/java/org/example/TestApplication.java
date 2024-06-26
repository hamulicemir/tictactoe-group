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

            int row = -1, col = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Player " + game.getCurrentPlayer().getMarker() + ", enter your move (row and column) (1-3): ");
                    row = Integer.parseInt(scanner.next()) - 1;
                    col = Integer.parseInt(scanner.next()) - 1;

                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("Invalid input. Please enter values between 1 and 3.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values between 1 and 3.");
                }
            }

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