package Ch09_Tree;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(solution(nodes)));
    }

    private static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();
        return result;
    }

    private static String postorder(int[] nodes, int i) {
        if (i >= nodes.length) {
            return "";
        }
        return postorder(nodes, 2 * i + 1) + postorder(nodes, 2 * i + 2) + nodes[i] + " ";
    }

    private static String inorder(int[] nodes, int i) {
        if (i >= nodes.length) {
            return "";
        }
        return inorder(nodes, 2 * i + 1) + nodes[i] + " " + inorder(nodes, 2 * i + 2);
    }

    private static String preorder(int[] nodes, int i) {
        if (i >= nodes.length) {
            return "";
        }
        return nodes[i] + " " + preorder(nodes, 2 * i + 1) + preorder(nodes, 2 * i + 2);
    }
}
