package Ch08_Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Programmers_42578
public class Pr01 {
    public static void main(String[] args) {
        // String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];

            if (!map.containsKey(type)) {
                map.put(type, new HashSet<>());
            }
            map.get(type).add(name);
        }

        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            answer *= (entry.getValue().size() + 1);
        }

        return answer - 1;
    }
}
