package Ch13_Sorting;

import java.util.Arrays;

// Programmers_17686
public class Pr01 {
    public static void main(String[] args) {
        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(solution(files)));
    }

    private static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Arrays.sort(files, (o1, o2) -> {
            String o1Head = o1.split("[0-9]")[0];
            String o2Head = o2.split("[0-9]")[0];

            int sortValue = o1Head.toLowerCase().compareTo(o2Head.toLowerCase());
            if (sortValue == 0) {
                sortValue = convert(o1, o1Head) - convert(o2, o2Head);
            }
            return sortValue;
        });
        answer = files;
        return answer;
    }

    private static int convert(String s, String head) {
        s = s.substring(head.length());
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) && sb.length() < 5) {
                sb.append(c);
            } else {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
