package com.virjanand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BowlingGame {
    private static final char ZERO = '0';
    private static final int MAX_SCORE = 10;
    private static final char STRIKE = 'X';
    private List<Character> scoresList;

    BowlingGame(String scorecard) {
        scoresList = scorecard.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    int getScore() {
        int sum = 0;
        replaceZeros();
        List<Integer> scoresAsInt = convertToNumbers();
        for (int score : scoresAsInt) {
            sum += score;
        }
        return sum;
    }

    private List<Integer> convertToNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scoresList.size(); i++) {
            result.add(convertToNumber(scoresList.get(i), i));
        }
        return result;
    }

    private int convertToNumber(Character character, int i) {
        if (i >= scoresList.size() - 2 && (scoresList.get(i - 2) == 'X' || scoresList.get(i - 1) == '/'))
            return 0;
        if (character == STRIKE)
            return MAX_SCORE + convertNextThrow(i, 1) + (convertNextThrow(i, 2));
        if (character == '/')
            return MAX_SCORE + convertNextThrow(i, 1) - convertNextThrow(i, -1);
        else return scoresList.get(i) - ZERO;
    }

    private int convertNextThrow(int i, int i2) {
        if (i >= scoresList.size() - 2)
            return 0;
        return scoresList.get(i + i2) == STRIKE ? MAX_SCORE : scoresList.get(i + i2) - ZERO;
    }

    private void replaceZeros() {
        for (int i = 0; i < scoresList.size(); i++) {
            if (scoresList.get(i) == '-')
                scoresList.set(i, ZERO);
        }
    }
}
