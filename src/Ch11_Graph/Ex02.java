package Ch11_Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex02 {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 8}};
        int start = 1, n = 9;
        System.out.println(Arrays.toString(solution(graph, start, n)));
    }

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            answer.add(now);
            for (int next : adjList[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
