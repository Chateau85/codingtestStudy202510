package Ch13_Sorting;

import java.util.Arrays;
import java.util.Collections;

// Programmers_12933
public class Ex04 {
    public static void main(String[] args) {
        long n = 118372;
        System.out.println(solution(n));
    }

    private static long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }
}
