package com.virjanand;

import java.util.Collection;
import java.util.stream.IntStream;

class BowlingGame {
    IntStream scorestream;

    public BowlingGame(String scorecard) {
        scorestream = scorecard.chars();
    }

    int getScore() {
        if (scorestream.filter(score -> score == '1').count() > 0) {
            return 1;
        }
        return 0;
    }
}
