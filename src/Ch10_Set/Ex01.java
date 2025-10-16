package Ch10_Set;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01 {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] operations = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        System.out.println(Arrays.toString(solution(k, operations)));
    }

    private static Boolean[] solution(int k, int[][] operations) {
        parent = new int[k];
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();
        for (int[] op : operations) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }
        return answer.toArray(new Boolean[0]);
    }
}
