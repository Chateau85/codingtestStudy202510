package Ch05_Array;

import java.util.Arrays;

// Programmers_87390
public class Pr03 {
    public static void main(String[] args) {
        int n = 3;
        long left = 2, right = 5;
        // int n = 4;
        // long left = 7, right = 14;
        System.out.println(Arrays.toString(solution(n, left, right)));
    }

    private static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            long index = left + i;
            long r = index / n;
            long c = index % n;
            answer[i] = (int) (Math.max(r, c) + 1);
        }
        return answer;
    }
}
