package Ch14_Simulation;

// Programmers_12980
public class Ex07 {
    public static void main(String[] args) {
        int N = 5000;
        System.out.println(solution(N));
    }

    private static int solution(int n) {
        // return Integer.toBinaryString(n).replace("0", "").length();
        String s = Integer.toBinaryString(n);
        s = s.replace("0", "");
        return s.length();
    }
}
