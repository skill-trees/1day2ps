import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 세계 최고의 갑부가 된 어피치는 스트레스 받을 때 오프라인 매장 쇼핑
        // 특정 범위 물건들을 모두 싹쓸이 구매하는 습관이 있다.
        // Ruby Dia Emerald Sapphire 8개가 진열된 예시

        // 진열대 3번부터 7번까지 5개의 보석을 구매하면 모든 종류의 보석을 적어도 하나 이상씩 포함

        // 3, 4, 6, 7번의 보석만 구매하는 것은 중간에 특정 구간이 빠지게 되므로 어피치의 쇼핑 습관에 맞지 않는다.

        // 진열대 번호 순서대로 보석들의 일므이 저장된 배열 gems가 매개변수로 주어짐
        // 이때 모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return
        // 가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호를 차례대로 배열에 담아서 return하도록 하며, 만약
        // 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 return

        // gems가 매개변수 이 때 모든 보석을 하나 이상 포함하는 가장 짧은 구간

        // dia * , ruby * , ruby * , dia * , dia * , emerald * , sapphire * , dia *
        // aa * , ab * , ac * , aa  , ac
        // xyz, xyz, xyz
        // zzz, yyy, nnnn, yyy, bbb

        // dia ruby ruby dia dia emerald spphire dia

        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }


        int start = 0;
        int temp = 0;
        int len = gems.length;

        Queue<String> queue = new LinkedList<>();

        for(int i = 0; i < gems.length; i++){
            // map에 해당 보석이 있으면 값을 +1, 없으면 0으로 설정
            map.put(gems[i], map.getOrDefault(gems[i],0) + 1);

            // 큐에 해당 보석 추가
            queue.add(gems[i]);

            while(true){

                // 큐에서 보석 맨 앞 값을 확인하기
                String gem = queue.peek();

                // System.out.println("큐에 들어있는 값"+gem);

                // 만약 map에 있는 보석의 값이 1 이상일 경우
                if(map.get(gem) > 1){

                    // map에 있는 보석의 값을 1 빼줌
                    map.put(gem, map.getOrDefault(gem,0) - 1);

                    // queue에서 맨 앞에 있는 요소를 빼줌
                    queue.poll();

                    // 인덱스를 하나 추가
                    temp++;
                    // System.out.println(start);
                }
                else{
                    break;
                }
            }

            if(map.size() == set.size()){
                if(len > queue.size()){
                    len = queue.size();
                    start = temp;
                }
            }
        }

        answer[0] = start + 1;
        answer[1] = start + len;

        return answer;
    }
}


