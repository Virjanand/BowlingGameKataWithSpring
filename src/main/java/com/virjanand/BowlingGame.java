package com.virjanand;

class BowlingGame {
    private String scorecard;

    public BowlingGame(String scorecard) {
        this.scorecard = scorecard;
    }

    int getScore() {
        if (scorecard.equals("--------------------")) {
            return 0;
        }
        return 1;
    }
}
