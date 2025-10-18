package Ch13_Sorting;

import java.util.Arrays;

// Programmers_42748
public class Ex05 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            int[] sliceArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sliceArr);
            answer[c] = sliceArr[k - 1];
        }
        return answer;
    }
}
