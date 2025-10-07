package Ch06_Stack;

import java.util.Stack;

public class Ex02 {
    public static void main(String[] args) {
        int decimal = 13;
        System.out.println(solution(decimal));

    }

    private static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
