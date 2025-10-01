package Ch05_Array;

import java.util.ArrayList;
import java.util.Arrays;

// Programmers_42840
public class Ex04 {
    public static void main(String[] args) {
        // int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }

    private static int[] solution(int[] answers) {
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
        };
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j] += 1;
                }
            }
        }
        int maxScore = Arrays.stream(scores).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
