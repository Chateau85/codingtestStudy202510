package Ch06_Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

// Programmers_12906
public class Pr01 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        // int[] arr = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i : arr) {
            if (stack.isEmpty() || stack.peekLast() != i) {
                stack.addLast(i);
            }
        }
        int[] answer = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            answer[index++] = stack.pollFirst();
        }
        return answer;
    }
}
