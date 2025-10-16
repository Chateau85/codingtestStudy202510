package Ch11_Graph;

// Programmers)43162
public class Ex05 {
    private static boolean[] visit;
    private static int[][] computer;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }

    private static void dfs(int now) {
        visit[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visit[now]) {
                dfs(i);
            }
        }
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer += 1;
            }
        }
        return answer;
    }
}
