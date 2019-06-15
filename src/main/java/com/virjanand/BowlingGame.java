package com.virjanand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BowlingGame {
    private static final char ZERO = '0';
    private static final int MAX_SCORE = 10;
    List<Character> scoresList;

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
            if (scoresList.get(i) == 'X')
                result.add(MAX_SCORE + (scoresList.get(i + 1) - ZERO));
            else result.add(scoresList.get(i) - ZERO);
        }
        return result;
    }

    private void replaceZeros() {
        for (int i = 0; i < scoresList.size(); i++) {
            if (scoresList.get(i) == '-')
                scoresList.set(i, ZERO);
        }
    }
}
