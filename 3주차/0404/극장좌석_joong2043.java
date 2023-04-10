import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 어떤 극장의 좌석은 한 줄로 되어 있으며
        // 왼쪽부터 차례대로 1번부터 N번까지 번호가
        // 공연을 보러 온 사람들은 자기의 입장권에 표시된 자석에 앉아야 함
        // 입장권 5번 -> 5번 좌석

        // 7번 입장권을 가진 사람은 7번 좌석은 물론 6번, 8번에 앉을 수 있음
        // 그러나 5번 좌석이나 9번 좌석에는 앉을 수 없다

        // vip 회원
        // 반드시 자기 좌석에만 앉아야 함
        // 옆 좌석으로 자리를 옮길 수 없다.
        // 오늘 공연은 입장권이 매진되어 1번 좌석부터 N번 좌석까지 모든 좌석이 다 팔림

        int num = Integer.parseInt(br.readLine());

        int fixNumLen = Integer.parseInt(br.readLine());

        int[] arr = new int[num+1];
        int[] dp = new int[num+1];

        for (int i = 1; i <= num; i++){
            arr[i] = i;
        }

        for (int i = 0 ; i < fixNumLen ; i++){
            int fixNum = Integer.parseInt(br.readLine());

            arr[fixNum] = 0;
        }

        // dp[0] 배열을 곱셈에서 사용하기 때문에 1로 설정
        dp[0] = 1;
        for (int i = 1; i <= num; i++){
            if (i <= 2){
                dp[i] = i;
                continue;
            }

            dp[i] = dp[i-2] + dp[i-1];
        }

        // 1 2 3 0 5 6
        // 2 1 3 0 5 6
        // 1 3 2 0 5 6
        // 1 2 3 0 0 0

        // dp[n] = dp[n-2] + dp[n-1]
        // dp[1] = 1;
        // dp[2] = 2;

        // 1 2 3 0 5 6 0 8 9
        int n = 0;
        int total = 1;
        for (int i = 1; i <= num; i++){
            // arr 배열의 값이 0이면 지금까지 구했던 dp 값을 total에 곱해주고 n을 0으로 초기화
            if (arr[i] == 0){
                total *= dp[n];
                n = 0;
            }
            else {
                n++;
            }

            // 만약 i가 마지막 인덱스이면 dp 값을 total에 곱해주기
            if (i == num){
                total *= dp[n];
            }
        }

        bw.write(total+"");

        bw.flush();
        br.close();
        bw.close();
    }


}