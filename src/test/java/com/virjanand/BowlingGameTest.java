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
    public void oneHit_score1() {
        BowlingGame bowlingGame = new BowlingGame("1-------------------");
        assertEquals(1, bowlingGame.getScore());
    }

    @Test
    public void allOneHits_score20() {
        BowlingGame bowlingGame = new BowlingGame("11111111111111111111");
        assertEquals(20 * 1, bowlingGame.getScore());
    }

    @Test
    public void differentNumbers_score15() {
        BowlingGame bowlingGame = new BowlingGame("12345---------------");
        assertEquals(1 + 2 + 3 + 4 + 5, bowlingGame.getScore());
    }

    @Test
    public void strike_add10AndDoubleNextThrow() {
        BowlingGame bowlingGame = new BowlingGame("X5------------------");
        assertEquals(10 + 2 * 5, bowlingGame.getScore());
    }
}
