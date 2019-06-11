package com.virjanand;

import java.util.stream.IntStream;

class BowlingGame {
    IntStream scorestream;

    public BowlingGame(String scorecard) {
        scorestream = scorecard.chars();
    }

    int getScore() {
        return scorestream.filter(score -> score == '1')
                .map(score -> score - '0')
                .sum();
    }
}
