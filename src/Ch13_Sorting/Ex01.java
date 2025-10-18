package Ch13_Sorting;

public class Ex01 {
    public static void main(String[] args) {
        String s = "algorithm";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
