package com.virjanand;

import java.util.stream.IntStream;

class BowlingGame {
    public static final char ZERO = '0';
    public static final int MAX_SCORE = 10;
    IntStream scorestream;

    public BowlingGame(String scorecard) {
        scorestream = scorecard.chars();
    }

    int getScore() {
        return scorestream.filter(this::isNonZero)
                .map(this::convertScore)
                .reduce(this::sumScores).orElse(0);
    }

    private boolean isNonZero(int score) {
        return score != '-';
    }

    private int sumScores(int sum, int nextThrow) {
        if (sum == 'X' - ZERO)
            return MAX_SCORE + 2 * nextThrow;
        return sum + nextThrow;
    }

    private int convertScore(int score) {
        return score - ZERO;
    }
}
