package Ch11_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Programmers_12978
public class Ex07 {
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;
        System.out.println(solution(N, road, K));
    }

    private static int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : road) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.dest] < now.cost) {
                continue;
            }
            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer += 1;
            }
        }
        return answer;
    }

    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
