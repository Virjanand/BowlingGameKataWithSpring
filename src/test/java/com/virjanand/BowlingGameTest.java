package com.virjanand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void noHit_score0() {
        BowlingGame bowlingGame = new BowlingGame("--------------------");
        assertEquals(0, bowlingGame.getScore());
    }

    @Test
    public void regularThrows_sumTotal() {
        BowlingGame bowlingGame = new BowlingGame("12345123451234512345");
        assertEquals(60, bowlingGame.getScore());
    }

    @Test
    public void strike_add10AndDoubleNextThrow() {
        BowlingGame bowlingGame = new BowlingGame("X5-X9---------------");
        assertEquals(10 + 2 * 5 + 10 + 2 * 9, bowlingGame.getScore());
    }

    @Test
    public void twoStrikes_compoundSum() {
        BowlingGame bowlingGame = new BowlingGame("XX5-----------------");
        assertEquals((10 + 10 + 5) + (10 + 5) + 5, bowlingGame.getScore());
    }

    @Test
    public void allStrikes_maxScore() {
        BowlingGame bowlingGame = new BowlingGame("XXXXXXXXXXXX");
        assertEquals(300, bowlingGame.getScore());
    }
}
