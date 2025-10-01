package Ch05_Array;

import java.util.Arrays;

// Programmers_120821
public class Pr02 {
    public static void main(String[] args) {
        // int[] num_list = {1, 2, 3, 4, 5};
        // int[] num_list = {1, 1, 1, 1, 1, 2};
        int[] num_list = {1, 0, 1, 1, 1, 3, 5};
        System.out.println(Arrays.toString(solution(num_list)));
    }

    private static int[] solution(int[] numList) {
        int[] answer = new int[numList.length];
        int answerIndex = 0;
        for (int i = numList.length - 1; i >= 0; i--) {
            answer[answerIndex] = numList[i];
            answerIndex += 1;
        }
        return answer;
    }
}
