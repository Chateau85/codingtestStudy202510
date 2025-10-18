package Ch12_Backtracking;

import java.util.ArrayList;

public class Ex01 {
    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    public static void main(String[] args) {
        int N = 7;
        System.out.println(solution(N));
    }

    private static void backtracking(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }
        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtracking(sum + i, list, i + 1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        backtracking(0, new ArrayList<>(), 1);
        return result;
    }
}
