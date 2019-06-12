package com.virjanand;

import java.util.stream.IntStream;

class BowlingGame {
    IntStream scorestream;

    public BowlingGame(String scorecard) {
        scorestream = scorecard.chars();
    }

    int getScore() {
        return scorestream.filter(score -> score == '1')
                .map(this::convertScore)
                .sum();
    }

    private int convertScore(int score) {
        return score - '0';
    }
}
