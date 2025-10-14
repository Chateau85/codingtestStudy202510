package Ch09_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

// Programmers_92343
public class Ex04 {
    private static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        System.out.println(solution(info, edges));
    }

    private static int solution(int[] info, int[][] edges) {
        buildTree(info, edges);
        int answer = 0;

        ArrayDeque<Info> q = new ArrayDeque<>();
        q.add(new Info(0, 1, 0, new HashSet<>()));

        while (!q.isEmpty()) {
            Info now = q.poll();
            answer = Math.max(answer, now.sheep);
            now.visited.addAll(tree[now.node]);

            for (int next : now.visited) {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if (info[next] == 1) {
                    if (now.sheep != now.wolf + 1) {
                        q.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                } else {
                    q.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }

        return answer;
    }

    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
}
