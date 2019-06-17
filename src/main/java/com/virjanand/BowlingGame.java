package com.virjanand;

import java.util.stream.IntStream;

class BowlingGame {
    private static final char ZERO = '0';
    private static final int MAX_SCORE = 10;

    private String scorecard;

    BowlingGame(String scorecard) {
        this.scorecard = scorecard;
    }

    int getScore() {
        return IntStream.range(0, scorecard.length()).map(this::convertScorecardCharacterToNumber).sum();
    }

    private int convertScorecardCharacterToNumber(int currentThrow) {
        if (isExtraThrow(currentThrow) || isZeroCharacter(currentThrow)) return 0;
        if (isSpareCharacter(currentThrow)) return CalculateSpareBasedOnNextThrow(currentThrow);
        if (isStrikeCharacter(currentThrow)) return calculateStrikeScoreBasedOnNext2Throws(currentThrow);
        return calculateRegularThrow(currentThrow);
    }

    private int CalculateSpareBasedOnNextThrow(int currentThrow) {
        return MAX_SCORE + convertNextThrow(currentThrow, 1) - convertNextThrow(currentThrow, -1);
    }

    private int calculateStrikeScoreBasedOnNext2Throws(int currentThrow) {
        return MAX_SCORE + convertNextThrow(currentThrow, 1) + (convertNextThrow(currentThrow, 2));
    }

    private int calculateRegularThrow(int currentThrow) {
        return scorecard.charAt(currentThrow) - ZERO;
    }

    private int convertNextThrow(int currentThrow, int offsetNextThrow) {
        if (isInLastTwoThrows(currentThrow) || isZeroCharacter(currentThrow + offsetNextThrow))
            return 0;
        if (isSpareCharacter(currentThrow + offsetNextThrow))
            return 5;
        if (isStrikeCharacter(currentThrow + offsetNextThrow))
            return MAX_SCORE;
        else
            return calculateRegularThrow(currentThrow + offsetNextThrow);
    }

    private boolean isExtraThrow(int throwNumber) {
        return isInLastTwoThrows(throwNumber) &&
                (isStrikeCharacter(throwNumber - 1)
                        || isStrikeCharacter(throwNumber - 2)
                        || isSpareCharacter(throwNumber - 1)
                );
    }

    private boolean isInLastTwoThrows(int currentThrow) {
        return currentThrow >= scorecard.length() - 2;
    }

    private boolean isZeroCharacter(int throwNumber) {
        return scorecard.charAt(throwNumber) == '-';
    }

    private boolean isSpareCharacter(int throwNumber) {
        return scorecard.charAt(throwNumber) == '/';
    }

    private boolean isStrikeCharacter(int throwNumber) {
        return scorecard.charAt(throwNumber) == 'X';
    }
}
