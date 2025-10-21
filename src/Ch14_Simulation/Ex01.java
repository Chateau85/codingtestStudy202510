package Ch14_Simulation;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = 3;
        System.out.println(Arrays.deepToString(solution(arr, n)));
    }

    private static int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }

    private static int[][] rotate90(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - i - 1] = arr[i][j];
            }
        }
        return rotatedArr;
    }
}
