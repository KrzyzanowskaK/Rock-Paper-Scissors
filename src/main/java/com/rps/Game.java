package com.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private ComputerChoice computerChoice = new ComputerChoice(new Random());
    private UserChoice userChoice = new UserChoice(scanner);
    private Menu menu = new Menu();
    private boolean roundFinished = false;
    private int userScore = 0 ;
    private int computerScore = 0 ;

    public void start() {
        String userName = menu.enterName(scanner);;
        int endingScore = menu.endingScore(scanner);

        System.out.println();
        System.out.println(menu.instruction());

        while (!roundFinished){
            String computer = computerChoice.play();
            String player = userChoice.play();
            System.out.println(player + " vs "+ computer);

            if (player.equals(computer)){
                System.out.println("TIE!");
                System.out.println(userName + " " + userScore + " vs Computer: " + computerScore);
                menu.checkScore(userName,userScore,computerScore);

            } else if (("Rock".equals(player) && "Scissors".equals(computer)) ||
                    ("Paper".equals(player) && "Rock".equals(computer)) ||
                    ("Scissors".equals(player) && "Paper".equals(computer))) {
                System.out.println(userName + " WIN!");
                userScore++;
                menu.checkScore(userName,userScore,computerScore);

            } else {
                System.out.println(userName + " LOSE!");
                computerScore++;
                menu.checkScore(userName,userScore,computerScore);
            }

            if(userScore == endingScore || computerScore == endingScore){
                System.out.println();
                System.out.println("End of the game!");
                System.out.println(userScore > computerScore ?
                        "Congratulation " + userName + "! You WIN! Your score: " + userScore : "Sorry, you lose, computer score: " + computerScore);
                menu.playAgain(scanner);
                roundFinished = true;
            }
        }
    }
}
