package Ch05_Array;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] solution(int[] org) {
        int[] clone = org.clone();
        Arrays.sort(clone);
        return clone;
    }
}
