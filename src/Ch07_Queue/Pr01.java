package Ch07_Queue;

import java.util.ArrayDeque;

// Programmers_42583
public class Pr01 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    private static int solution(int bridgeLength, int weight, int[] truckWeights) {
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridgeLength; i++) {
            bridge.addLast(0);
        }
        for (int truckWeight : truckWeights) {
            trucks.addLast(truckWeight);
        }
        int answer = 0;
        int bridgeWeight = 0;
        while (!bridge.isEmpty()) {
            bridgeWeight -= bridge.peekFirst();
            bridge.pollFirst();
            if (trucks.isEmpty()) {
                answer += bridgeLength;
                break;
            } else {
                if (bridgeWeight + trucks.peekFirst() <= weight) {
                    bridge.addLast(trucks.getFirst());
                    bridgeWeight += trucks.getFirst();
                    trucks.pollFirst();
                } else {
                    bridge.addLast(0);
                }
            }
            answer += 1;
        }
        return answer;
    }
}
