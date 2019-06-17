package com.virjanand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void noHit() {
        checkScoreCardTotal("--------------------", 0);
    }

    @Test
    public void regularThrows() {
        checkScoreCardTotal("12345123451234512345", 60);
    }

    @Test
    public void strike() {
        checkScoreCardTotal("X5-X9---------------", 10 + 2 * 5 + 10 + 2 * 9);
    }

    @Test
    public void twoStrikes() {
        checkScoreCardTotal("XX5-----------------", (10 + 10 + 5) + (10 + 5) + 5);
    }

    @Test
    public void allStrikes() {
        checkScoreCardTotal("XXXXXXXXXXXX", 300);
    }

    @Test
    public void spare() {
        checkScoreCardTotal("5/5/5/5/5/5/5/5/5/5/5", 150);
    }

    @Test
    public void spareAfterStrike() {
        checkScoreCardTotal("X5/----------------", 30);
    }

    @Test
    public void normalThrowsAfterLastStrike() {
        checkScoreCardTotal("------------------X12", 13);
    }

    private void checkScoreCardTotal(String s, int i) {
        BowlingGame bowlingGame = new BowlingGame(s);
        assertEquals(i, bowlingGame.getScore());
    }
}
