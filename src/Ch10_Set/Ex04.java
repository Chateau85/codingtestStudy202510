package Ch10_Set;

import java.util.Arrays;
import java.util.Comparator;

// Programmers_42861
public class Ex04 {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }

    private static int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0, edges = 0;
        for (int[] edge : costs) {
            if (edges == n - 1) {
                break;
            }
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges += 1;
            }
        }
        return answer;
    }
}
