package Ch09_Tree;

// Programmers_12985
public class Ex02 {
    public static void main(String[] args) {
        int N = 8, A = 4, B = 7;
        System.out.println(solution(N, A, B));
    }

    private static int solution(int n, int a, int b) {
        int answer = 0;
        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
}
