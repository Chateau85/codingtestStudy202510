package Ch10_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// Programmers_1845
public class Ex02 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int n = nums.length;
        int k = n / 2;
        return Math.min(k, set.size());
    }
}
