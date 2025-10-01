package Ch05_Array;

import java.util.Arrays;
import java.util.HashSet;

// Programmers_68644
public class Ex03 {
    public static void main(String[] args) {
        // int[] numbers = {2,1,3,4,1};
        int[] numbers = {5, 0, 2, 7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    private static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
