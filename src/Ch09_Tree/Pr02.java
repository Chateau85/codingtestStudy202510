package Ch09_Tree;

import java.util.*;

// Programmers_68937
public class Pr02 {
    private static List<Integer>[] adj; // 인접 리스트 (트리 구조)
    private static int N; // 노드의 개수

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(n, edges));
    }

    public static int solution(int n, int[][] edges) {
        N = n;

        // 1. 인접 리스트 초기화 및 구성
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // 2. 1차 BFS: 임의의 노드(1)에서 가장 먼 노드 A를 찾음
        int nodeA = findFarthestNode(1);

        // 3. 2차 BFS: 노드 A에서 가장 먼 노드 B를 찾음. (A와 B는 트리의 지름을 이루는 끝점)
        int nodeB = findFarthestNode(nodeA);

        // 4. A와 B 각각에 대해 모든 노드까지의 거리를 계산 (distA, distB)
        int[] distA = bfs(nodeA);
        int[] distB = bfs(nodeB);

        // 5. 모든 노드 i에 대해 min(distA[i], distB[i])의 최댓값을 찾음
        int maxMinDist = 0;

        for (int i = 1; i <= n; i++) {
            // i 노드에서 A와 B까지의 거리 중 더 작은 값
            int minDist = Math.min(distA[i], distB[i]);

            // 이 작은 값들 중 최댓값 업데이트
            if (minDist > maxMinDist) {
                maxMinDist = minDist;
            }
        }

        // maxMinDist가 바로 트리의 지름을 이루는 두 끝점으로부터
        // 모든 노드의 거리 중 작은 값의 최댓값이 되며, 이것이 정답이다.
        return maxMinDist;
    }

    /**
     * start 노드에서 모든 노드까지의 거리를 계산하여 배열로 반환하는 BFS 함수
     *
     * @param start BFS를 시작할 노드
     * @return 각 노드까지의 거리가 담긴 배열 (1-based index)
     */
    private static int[] bfs(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1); // 방문하지 않음을 -1로 표시

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }

    /**
     * BFS를 통해 start 노드에서 가장 멀리 떨어진 노드의 인덱스를 찾음
     *
     * @param start BFS를 시작할 노드
     * @return 가장 먼 노드의 인덱스
     */
    private static int findFarthestNode(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        dist[start] = 0;
        int farthestNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            if (dist[u] > maxDist) {
                maxDist = dist[u];
                farthestNode = u; // 현재까지 가장 먼 노드 업데이트
            }

            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return farthestNode;
    }
}
