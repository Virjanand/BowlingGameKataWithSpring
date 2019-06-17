package com.virjanand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BowlingGame {
    private static final char ZERO = '0';
    private static final char STRIKE = 'X';
    private static final char SPARE = '/';
    private static final int MAX_SCORE = 10;

    private List<Character> scoresList;

    BowlingGame(String scorecard) {
        scoresList = scorecard.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    int getScore() {
        return convertToNumbers().stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> convertToNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scoresList.size(); i++) {
            result.add(convertToNumber(scoresList.get(i), i));
        }
        return result;
    }

    private int convertToNumber(Character character, int currentThrow) {
        if (isExtraThrow(currentThrow) || isZeroCharacter(currentThrow))
            return 0;
        if (character == STRIKE)
            return MAX_SCORE + convertNextThrow(currentThrow, 1) + (convertNextThrow(currentThrow, 2));
        if (character == SPARE)
            return MAX_SCORE + convertNextThrow(currentThrow, 1) - convertNextThrow(currentThrow, -1);
        else return scoresList.get(currentThrow) - ZERO;
    }

    private boolean isExtraThrow(int throwNumber) {
        return isInLastTwoThrows(throwNumber) && (isStrikeCharacter(throwNumber) || isSpareCharacter(throwNumber));
    }

    private int convertNextThrow(int currentThrow, int offsetNextThrow) {
        if (isInLastTwoThrows(currentThrow) || isZeroCharacter(currentThrow + offsetNextThrow))
            return 0;
        if (scoresList.get(currentThrow + 2) == SPARE)
            return 5;
        return scoresList.get(currentThrow + offsetNextThrow) == STRIKE ? MAX_SCORE : scoresList.get(currentThrow + offsetNextThrow) - ZERO;
    }

    private boolean isInLastTwoThrows(int currentThrow) {
        return currentThrow >= scoresList.size() - 2;
    }

    private boolean isZeroCharacter(int throwNumber) {
        return scoresList.get(throwNumber) == '-';
    }

    private boolean isSpareCharacter(int throwNumber) {
        return scoresList.get(throwNumber - 1) == '/';
    }

    private boolean isStrikeCharacter(int throwNumber) {
        return scoresList.get(throwNumber - 2) == 'X';
    }
}
