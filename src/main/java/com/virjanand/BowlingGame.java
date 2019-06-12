package com.virjanand;

import java.util.stream.IntStream;

class BowlingGame {
    IntStream scorestream;

    public BowlingGame(String scorecard) {
        scorestream = scorecard.chars();
    }

    int getScore() {
        return scorestream.filter(score -> score != '-')
                .map(this::convertScore)
                .reduce(this::sumScores).orElse(0);
    }

    private int sumScores(int sum, int nextThrow) {
        return sum+nextThrow;
    }

    private int convertScore(int score) {
        return score - '0';
    }
}
