package com.rps;

import java.util.Random;

public class ComputerChoice implements PlayRPS {
    private Random random;

    public ComputerChoice(Random random) {
        this.random = random;
    }

    @Override
    public String play() {
        return choosing[this.random.nextInt(choosing.length)];
    }
}
