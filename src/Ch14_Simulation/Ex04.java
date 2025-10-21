package Ch14_Simulation;

import java.util.Arrays;

// Programmers_70129
public class Ex04 {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int countTransform = 0;
        int countZero = 0;

        while (!s.equals("1")) {
            countTransform += 1;
            int zero = s.replace("1", "").length();
            countZero += zero;
            s = Integer.toBinaryString(s.length() - zero);
        }
        return new int[]{countTransform, countZero};
    }
}
