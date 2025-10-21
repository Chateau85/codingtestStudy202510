package Ch14_Simulation;

import java.util.HashMap;
import java.util.HashSet;

// Programmers_132265
public class Ex05 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));
    }

    private static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> toppingMap = new HashMap<>();
        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) + 1);
        }

        HashSet<Integer> toppingSet = new HashSet<>();
        for (int t : topping) {
            toppingSet.add(t);
            toppingMap.put(t, toppingMap.get(t) - 1);

            if (toppingMap.get(t) == 0) {
                toppingMap.remove(t);
            }

            if (toppingSet.size() == toppingMap.size()) {
                answer += 1;
            }
        }
        return answer;
    }
}
