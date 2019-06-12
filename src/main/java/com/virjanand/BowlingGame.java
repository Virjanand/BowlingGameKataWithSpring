package com.virjanand;

class BowlingGame {
    public static final char ZERO = '0';
    public static final int MAX_SCORE = 10;
    char[] scores;

    public BowlingGame(String scorecard) {
        scores = scorecard.toCharArray();
    }

    int getScore() {
        int sum = 0;
        for (char score : scores) {
            if (isNonZero(score)) {
                int tempScore = convertScore(score);
                sum = sumScores(sum, tempScore);
            }
        }
        return sum;
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
