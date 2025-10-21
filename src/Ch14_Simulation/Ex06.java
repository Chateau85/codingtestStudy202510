package Ch14_Simulation;

import java.util.Arrays;

// Programmers_42842
public class Ex06 {
    public static void main(String[] args) {
        int red = 10, white = 2;
        System.out.println(Arrays.toString(solution(red, white)));
    }

    private static int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;
        int sqrt = (int) Math.sqrt(totalSize);
        for (int vertical = 3; vertical <= sqrt; vertical++) {
            if (totalSize % vertical == 0) {
                int horizontal = totalSize / vertical;
                if (brown == (horizontal + vertical - 2) * 2) {
                    return new int[]{horizontal, vertical};
                }
            }
        }
        return new int[]{};
    }
}
