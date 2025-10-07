package Ch07_Queue;

import java.util.ArrayDeque;

public class Ex01 {
    public static void main(String[] args) {
        int N = 5, K = 2;
        System.out.println(solution(N, K));
    }

    private static int solution(int N, int K) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        while (deque.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }
        return deque.pollFirst();
    }
}
