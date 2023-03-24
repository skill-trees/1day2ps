import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        // 보석 종류 구하기
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        // 구매하기 슬라이딩 형식
        int start = 0, temp = 0, len = gems.length;
        // 해당 구간을 구하기 위한 큐
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < gems.length; i++) {
            // 보석 집어넣기
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            // 구간을 구하기 위해 큐 안에 집어넣기
            q.add(gems[i]);
            // 집어넣을때마다 큐 통해서 여러 보석 있으면 start를 앞으로 이동 (보석 중복 최소화)
            while (true) {
                String gem = q.peek();
                if (map.get(gem) > 1) {
                    map.put(gem, map.get(gem) - 1);
                    q.poll();
                    temp++;
                } else
                    break;
            }
            // 보석 종류 맞으면
            if (map.size() == set.size()) {
                // 해당 구간이랑 len이랑 비교해서 해당 구간이 더 짧은 경우(최적) 업데이트 -> 테스트 케이스 참고
                if (len > q.size()) {
                    len = q.size();
                    start = temp;
                }
            }
        }

        return new int[] { start + 1, start + len };

    }
}