package Ch11_Graph;

import java.util.ArrayDeque;

// Programmers_1844
public class Ex04 {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    private static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        int[][] dist = new int[N][M];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.addLast(new Node(0, 0));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Node now = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || maps[nr][nc] == 0) {
                    continue;
                }
                if (dist[nr][nc] == 0) {
                    q.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
