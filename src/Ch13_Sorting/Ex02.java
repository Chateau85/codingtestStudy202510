package Ch13_Sorting;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }

    private static int[] solution(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int k = 0, i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            merged[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }
}
