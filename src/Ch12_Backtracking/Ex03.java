package Ch12_Backtracking;

// Programmers_87946
public class Ex03 {
    private static int answer;
    private static int[][] Dungeons;
    private static boolean[] visited;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }

    private static int solution(int k, int[][] dungeons) {
        answer = 0;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        backtracking(k, 0);
        return answer;
    }

    private static void backtracking(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backtracking(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
