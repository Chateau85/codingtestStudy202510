package Ch13_Sorting;

import java.util.Arrays;
import java.util.HashSet;

// Programmers_64065
public class Ex07 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        s = s.substring(0, s.length() - 2).replace("{", "");
        String[] arr = s.split("},");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String[] numbers = arr[i].split(",");
            for (String number : numbers) {
                if (!set.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }
        return answer;
    }
}
