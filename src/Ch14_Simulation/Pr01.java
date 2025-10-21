package Ch14_Simulation;

// Programmers_42860
public class Pr01 {
    public static void main(String[] args) {
        String name = "JAN";
        System.out.println(solution(name));
    }

    private static int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next += 1;
            }
            move = Math.min(move, Math.min(i, n - next) + i + n - next);
        }
        answer += move;
        return answer;
    }
}
