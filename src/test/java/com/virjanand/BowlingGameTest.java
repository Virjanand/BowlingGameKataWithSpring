package com.virjanand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void nothingHit_score0() {
        BowlingGame bowlingGame = new BowlingGame();
        assertEquals(0, bowlingGame.getScore());
    }
}
