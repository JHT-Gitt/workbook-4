package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int playerCount = 0;
        String name;
        boolean isAgain = false;

        while(!isAgain) {
            while (true) {
                try {
                    System.out.print("\nEnter how many players are playing (for now max is 5): ");
                    playerCount = scanner.nextInt();
                    scanner.nextLine();
                    if (playerCount <= 1 || playerCount > 5) {
                        System.out.println("\nPlayers must be more than 1 and less than 5");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nOnly number please. Try again");
                    scanner.nextLine();
                }
            }
            ArrayList<Player> players = new ArrayList<>(playerCount);

            int points = 0;
            String winner = "";
            boolean tie = false;

            for (int i = 0; i < playerCount; i++) {
                System.out.print("Enter the player " + (i + 1) + ": ");
                name = scanner.next();
                players.add(new Player(name));
            }
            System.out.println("\n");
            Deck deck = new Deck();
            deck.shuffle();
            for (Player p : players) {

                Hand hand = new Hand(p.getName());
                for (int i = 0; i < 2; i++) {
                    Cards card = deck.deal();
                    hand.deal(card);
                    System.out.println("Deal: " + (i+1));
                    System.out.println(hand.getName() + ": " + card.getValue() + " " + card.getSuits());
                }
                int total = hand.getValue();
                if(total == 22){
                    total = 2;
                }
                System.out.println("Player: " + hand.getName() + " -  Total points: " + total + "\n");

                if (total > points) {
                    points = total;
                    winner = hand.getName();
                    tie = false;
                } else if (total == points) {
                    tie = true;
                }

            }
            if (tie) {
                System.out.println("\nWe have a tie ! Only 1 can be a winner");
            } else {
                System.out.println("\nThe winner is player " + winner.toUpperCase() + " with " + points + " points!");
            }
            while(true) {
                scanner.nextLine();
                System.out.print("\nPlay again ?[Y/N] :");
                String again = scanner.next();
                if (again.equalsIgnoreCase("y")) {
                    System.out.println("\nMay the Luckiest player wins");
                    break;
                } else if (again.equalsIgnoreCase("N")) {
                    System.exit(0);
                    isAgain = true;
                }
            }
        }

    }
}