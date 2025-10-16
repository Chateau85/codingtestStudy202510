package Ch10_Set;

import java.util.Arrays;
import java.util.HashSet;

// Programmers_12981
public class Ex03 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    private static int[] solution(int n, String[] words) {
        HashSet<String> usedWords = new HashSet<>();
        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            usedWords.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}
