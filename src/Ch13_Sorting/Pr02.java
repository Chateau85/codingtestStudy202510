package Ch13_Sorting;

import java.util.Arrays;

// Programmers_42747
public class Pr02 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    private static int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i >= 1; i--) {
            if (citations[citations.length - i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
