package Ch05_Array;

// Programmers_120817
public class Pr01 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        System.out.println(solution(numbers));
    }

    private static double solution(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}
