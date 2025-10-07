package Ch06_Stack;

import java.util.Stack;

// Programmers_120853
public class Pr02 {
    public static void main(String[] args) {
        // String s = "1 2 Z 3";
        // String s = "10 20 30 40";
        // String s = "10 Z 20 Z 1";
        // String s = "10 Z 20 Z";
        String s = "-1 -2 -3 Z";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] arr = s.split(" ");
        for (String string : arr) {
            if (string.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(string));
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
