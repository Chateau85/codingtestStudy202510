package Ch08_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Programmers_92334
public class Ex06 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    private static int[] solution(String[] id_List, String[] report, int k) {
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }
        int[] answer = new int[id_List.length];
        for (int i = 0; i < id_List.length; i++) {
            answer[i] = count.getOrDefault(id_List[i], 0);
        }
        return answer;
    }
}
