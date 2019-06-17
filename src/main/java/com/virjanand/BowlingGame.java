package com.virjanand;

import java.util.stream.IntStream;

class BowlingGame {
    private static final char ZERO = '0';
    private static final char STRIKE = 'X';
    private static final char SPARE = '/';
    private static final int MAX_SCORE = 10;

    private String scorecard;

    BowlingGame(String scorecard) {
        this.scorecard = scorecard;
    }

    int getScore() {
        return IntStream.range(0, scorecard.length()).map(this::convertToNumber).sum();
    }

    private int convertToNumber(int currentThrow) {
        if (isExtraThrow(currentThrow) || isZeroCharacter(currentThrow)) {
            return 0;
        }
        char character = scorecard.charAt(currentThrow);
        if (character == STRIKE)
            return MAX_SCORE + convertNextThrow(currentThrow, 1) + (convertNextThrow(currentThrow, 2));
        if (character == SPARE)
            return MAX_SCORE + convertNextThrow(currentThrow, 1) - convertNextThrow(currentThrow, -1);
        else return scorecard.charAt(currentThrow) - ZERO;
    }

    private boolean isExtraThrow(int throwNumber) {
        return isInLastTwoThrows(throwNumber) && (isStrikeCharacter(throwNumber) || isSpareCharacter(throwNumber));
    }

    private int convertNextThrow(int currentThrow, int offsetNextThrow) {
        if (isInLastTwoThrows(currentThrow) || isZeroCharacter(currentThrow + offsetNextThrow))
            return 0;
        if (scorecard.charAt(currentThrow + 2) == SPARE)
            return 5;
        return scorecard.charAt(currentThrow + offsetNextThrow) == STRIKE ? MAX_SCORE : scorecard.charAt(currentThrow + offsetNextThrow) - ZERO;
    }

    private boolean isInLastTwoThrows(int currentThrow) {
        return currentThrow >= scorecard.length() - 2;
    }

    private boolean isZeroCharacter(int throwNumber) {
        return scorecard.charAt(throwNumber) == '-';
    }

    private boolean isSpareCharacter(int throwNumber) {
        return scorecard.charAt(throwNumber - 1) == '/';
    }

    private boolean isStrikeCharacter(int throwNumber) {
        return scorecard.charAt(throwNumber - 2) == 'X';
    }
}
