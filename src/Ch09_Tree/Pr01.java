package Ch09_Tree;

// Programmers_43238
public class Pr01 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    private static long solution(int n, int[] times) {
        long answer = 0;

        long left = 0, right = times[times.length - 1] * (long) n;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
