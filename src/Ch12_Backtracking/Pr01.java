package Ch12_Backtracking;

import java.util.ArrayList;

// Programmers_84512
public class Pr01 {
    private static final char[] CHARS = "AEIOU".toCharArray();

    public static void main(String[] args) {
        String word = "UUUUO";
        System.out.println(solution(word));
    }

    private static int solution(String word) {
        ArrayList<String> words = new ArrayList<>();
        backtracking("", words);
        return words.indexOf(word);
    }

    private static void backtracking(String word, ArrayList<String> words) {
        words.add(word);
        if (word.length() == 5) {
            return;
        }

        for (char c : CHARS) {
            backtracking(word + c, words);
        }
    }
}
