package Ch05_Array;

import java.util.Arrays;
import java.util.HashSet;

// Programmers_12910
public class Pr04 {
    public static void main(String[] args) {
        // int[] arr = {5, 9, 7, 10}; int divisor = 5;
        // int[] arr = {2, 36, 1, 3}; int divisor = 1;
        int[] arr = {3, 2, 6};
        int divisor = 10;
        System.out.println(Arrays.toString(solution(arr, divisor)));
    }

    private static int[] solution(int[] arr, int divisor) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (j % divisor == 0) {
                set.add(j);
            }
        }
        return set.isEmpty() ? new int[]{-1} : set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
