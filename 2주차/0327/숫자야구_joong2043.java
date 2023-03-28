
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 마음속으로 생각한다.
        // 민혁이는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 영수에게 묻는다.
        // 민혁이가 말한 세 자리 수에 있는 숫자들 중 하나가 세 자리수의 동일한 자리에 위치하면 스트라이크

        // 민혁이가 영수에게 몇 번이나 질문을 했는지를 나타내는 1이상 100 이하의 자연수 N이 주어진다.
        // 이어지는 N개의 줄에는 각 줄마다 민혁이가 질문한 세 자리 수와 영수가 답한 스트라이크 개수를 나타내는 정수와 볼의 개수를 나타내는 정수

        int num = Integer.parseInt(br.readLine());

        // 123 1 1 -> 130 134 135 136 137 138 139 324
        // 356 1 0
        // 327 2 0
        // 489 0 1

        List<Baseball> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());

            String trial = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Baseball 객체 생성
            Baseball baseball = new Baseball(trial,s,b);

            // 리스트에 Baseball 객체들 쭉 넣기
            list.add(baseball);
        }

        int count = checkNumberBaseBall(list);

        bw.write(count+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static int checkNumberBaseBall(List<Baseball> baseballList){
        int cnt = 0;
        for (int i = 123; i <999; i++){
            // 검사하려고 하는 수가 각자 다른 숫자를 가지는 수일 경우 체크
            String number = String.valueOf(i);
            boolean correct = true;

            // 만약 같은 숫자를 가진 자리가 있다면 continue
            if (checkIfEquals(number)){
                continue;
            }
            else {
                for (Baseball baseball : baseballList){
                    // 테스트용 strike와 ball을 초기화
                    int strike = 0;
                    int ball = 0;

                    // 세 자리 각각의 자리수가 같은 지를 확인하기 위한 반복문 -> strike
                    for (int j = 0; j < 3; j++){
                        if (number.charAt(j) == baseball.trial.charAt(j)){
                            strike++;
                        }
                    }

                    // 세 자리 각각의 자리수와 자리는 다르지만 값은 같은 지 확인 용 -> ball
                    // 213 -> 312
                    if (number.charAt(0) == baseball.trial.charAt(1) || number.charAt(0) == baseball.trial.charAt(2)){
                        ball++;
                    }
                    if (number.charAt(1) == baseball.trial.charAt(0) || number.charAt(1) == baseball.trial.charAt(2)){
                        ball++;
                    }
                    if (number.charAt(2) == baseball.trial.charAt(0) || number.charAt(2) == baseball.trial.charAt(1)){
                        ball++;
                    }

                    // 만약 스트라이크 개수나 볼 개수가 다를 경우
                    if (strike != baseball.strike || ball != baseball.ball){
                        correct = false;
                        break;
                    }
                }

            }
            if (correct){
//                System.out.println(i);
                cnt++;
            }
        }
        return cnt;
    }

    static boolean checkIfEquals(String n){

        if (n.charAt(0) == n.charAt(1)){
            return true;
        }
        if (n.charAt(0) == n.charAt(2)){
            return true;
        }
        if (n.charAt(1) == n.charAt(2)){
            return true;
        }
        // 자리수에 0이 있는 지 확인
        for (int i = 0; i < 3; i++){
            if (n.charAt(i)=='0'){
                return true;
            }
        }
        return false;

    }

}
// Baseball 클래스 생성
class Baseball{
    String trial;
    int strike;
    int ball;

    Baseball(String trial, int strike, int ball){
        this.trial = trial;
        this.strike = strike;
        this.ball = ball;
    }

}