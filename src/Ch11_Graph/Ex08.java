package Ch11_Graph;

import java.util.ArrayDeque;

// Programmers_67259
public class Ex08 {
    private static final int[] rx = {0, -1, 0, 1};
    private static final int[] ry = {-1, 0, 1, 0};
    private static int N;
    private static int[][][] visited;

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
    }

    private static int calculateCost(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
            return cost + 100;
        }
        return cost + 600;
    }

    private static boolean isShouldUpdate(int x, int y, int direction, int newCost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];
        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now.x + rx[i];
                int newY = now.y + ry[i];

                if (isBlocked(board, newX, newY)) {
                    continue;
                }
                int newCost = calculateCost(i, now.direction, now.cost);
                if (newX == N - 1 && newY == N - 1) {
                    answer = Math.min(answer, newCost);
                } else if (isShouldUpdate(newX, newY, i, newCost)) {
                    q.add(new Node(newX, newY, i, newCost));
                    visited[newX][newY][i] = newCost;
                }

            }
        }
        return answer;
    }

    private static class Node {
        int x, y, direction, cost;

        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
}
