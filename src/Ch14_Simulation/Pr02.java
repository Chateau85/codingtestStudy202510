package Ch14_Simulation;

import java.util.Arrays;

// Programmers_60061
public class Pr02 {
    private static boolean[][] pillar;
    private static boolean[][] bar;

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        System.out.println(Arrays.deepToString(solution(n, build_frame)));
    }

    private static int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 1][n + 1];
        bar = new boolean[n + 1][n + 1];

        int count = 0;
        for (int[] ints : build_frame) {
            int x = ints[0];
            int y = ints[1];
            int a = ints[2];
            int b = ints[3];

            if (a == 0) {
                if (b == 1) {
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count += 1;
                    }
                } else {
                    pillar[x][y] = false;
                    if (canDelete(n)) {
                        pillar[x][y] = true;
                    } else {
                        count -= 1;
                    }
                }
            } else {
                if (b == 1) {
                    if (checkBar(x, y)) {
                        bar[x][y] = true;
                        count += 1;
                    }
                } else {
                    bar[x][y] = false;
                    if (canDelete(n)) {
                        bar[x][y] = true;
                    } else {
                        count -= 1;
                    }
                }
            }
        }
        int[][] result = new int[count][3];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j]) {
                    result[index][0] = i;
                    result[index][1] = j;
                    result[index++][2] = 0;
                }
                if (bar[i][j]) {
                    result[index][0] = i;
                    result[index][1] = j;
                    result[index++][2] = 1;
                }
            }
        }
        return result;
    }

    private static boolean canDelete(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j] && !checkPillar(i, j)) {
                    return true;
                } else if (bar[i][j] && !checkBar(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkBar(int x, int y) {
        if (y > 0 && pillar[x][y - 1] || pillar[x + 1][y - 1]) {
            return true;
        } else return x > 0 && bar[x - 1][y] && bar[x + 1][y];
    }

    private static boolean checkPillar(int x, int y) {
        if (y == 0) {
            return true;
        } else if (y > 0 && pillar[x][y - 1]) {
            return true;
        } else return x > 0 && bar[x - 1][y] || bar[x][y];
    }
}
