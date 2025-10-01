package Ch05_Array;

import java.util.Arrays;
import java.util.HashMap;

// Programmers_42889
public class Ex06 {
    public static void main(String[] args) {
        // int N = 5;        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(solution(N, stages)));
    }

    private static int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();
    }
}
