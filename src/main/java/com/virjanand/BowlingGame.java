package com.virjanand;

import java.util.Collection;
import java.util.stream.IntStream;

class BowlingGame {
    private String scorecard;
    IntStream scorestream;

    public BowlingGame(String scorecard) {
        this.scorecard = scorecard;
        scorestream = scorecard.chars();
    }

    int getScore() {
        if (scorestream.filter(score -> score == '1').count() > 0) {
            return 1;
        }
        if (scorecard.equals("--------------------")) {
            return 0;
        }
        return -1;
    }
}
