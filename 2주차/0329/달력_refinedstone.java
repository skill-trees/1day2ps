package 문지언님스터디;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 달력{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<List<Integer>> pq = IntStream.range(0, sc.nextInt()).mapToObj(i -> List.of(sc.nextInt(), sc.nextInt())).collect(Collectors.toCollection(() -> new PriorityQueue<>(
                        (x1, x2) -> x1.get(0) == x2.get(0) ? x1.get(1) - x1.get(0) - (x2.get(1) - x2.get(0)) : x1.get(0) - x2.get(0))));
        /*q->맵으로 저장*/
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!pq.isEmpty()) {
            List<Integer> poll = pq.poll();
            IntStream.rangeClosed(poll.get(0), poll.get(1)).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        }
        /*main-logic*/
        int answer = 0;
        int startKey = -1;
        int endKey = -1;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (startKey == -1 || key != endKey + 1) {
                answer += (endKey - startKey + 1) * max;
                startKey = key;
                max = 0;
            }
            max = Math.max(max, value);
            endKey = key;
        }
        answer += (endKey - startKey + 1) * max;
      
        System.out.println(answer);
    }
}
