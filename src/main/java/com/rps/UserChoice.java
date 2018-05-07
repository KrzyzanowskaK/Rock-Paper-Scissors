package com.rps;

import java.util.Scanner;

public class UserChoice implements PlayRPS {
    private Scanner scanner ;

    public UserChoice(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String play() {
        System.out.println();
        System.out.println("Select 1 for Rock, 2 for Paper or 3 for Scissors");
        int choice = this.scanner.nextInt();
        return PlayRPS.choosing[choice - 1];
    }
}
