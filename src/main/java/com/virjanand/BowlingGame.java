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
        if (isExtraThrow(currentThrow) || scoresList.get(currentThrow) == '-')
            return 0;
        if (character == STRIKE)
            return MAX_SCORE + convertNextThrow(currentThrow, 1) + (convertNextThrow(currentThrow, 2));
        if (character == SPARE)
            return MAX_SCORE + convertNextThrow(currentThrow, 1) - convertNextThrow(currentThrow, -1);
        else return scoresList.get(currentThrow) - ZERO;
    }

    private boolean isExtraThrow(int throwNumber) {
        return throwNumber >= scoresList.size() - 2 && (scoresList.get(throwNumber - 2) == 'X' || scoresList.get(throwNumber - 1) == '/');
    }

    private int convertNextThrow(int i, int i2) {
        if (i >= scoresList.size() - 2 || scoresList.get(i + i2) == '-')
            return 0;
        if (scoresList.get(i + 2) == SPARE)
            return 5;
        return scoresList.get(i + i2) == STRIKE ? MAX_SCORE : scoresList.get(i + i2) - ZERO;
    }
}
