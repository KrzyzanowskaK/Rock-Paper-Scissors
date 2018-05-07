package com.rps;

import java.util.Scanner;

public class Menu {
    public String instruction() {
        return "Instructions: Key 1 - rock Key 2 - paper Key 3 - scissors Key x - end of game Key n - new game";
    }

    public String enterName(Scanner scanner) {
        String userName;
        System.out.print("Enter your name: ");
        userName = scanner.next();
        return userName;
    }

    public int endingScore (Scanner scanner) {
        System.out.print("How much wins to end the game? ");
        int endingScore = 0;
        boolean correctWins = false;
        while (!correctWins) {
            String value = scanner.next();
            try {
                endingScore = Integer.parseInt(value);
                if (endingScore == 0) {
                    System.out.println("Number must be greater than zero");
                } else {
                    correctWins = true;
                }
            } catch(NumberFormatException e) {
                System. out. println("Please input number ");
            }
        }
        return endingScore;
    }

    public boolean playAgain(Scanner scanner){
        boolean correctKey = false;
        while (!correctKey) {
            System.out.println("Do You want to play a new game (n) or end (x) ?");
            switch (scanner.next()) {
                case "n":
                    return areYouSure(scanner);
                case "x":
                    System.out.println("Thank you for playing!");
                    correctKey = true;
                    break;
            }
        }
        return false;
    }

    public boolean areYouSure(Scanner scanner){
        System.out.println("Are You sure y/n?");
        switch (scanner.next()){
            case "y" :
                Game game = new Game();
                game.start();
                return true;
            case "n":
                return playAgain(scanner);
        }
        return false;
    }

    public void checkScore(String userName, int userScore, int computerScore){
        System.out.println(userName + " " + userScore + " vs Computer: " + computerScore);
    }
}