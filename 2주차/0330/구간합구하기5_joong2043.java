
import java.awt.*;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 표의 크기 a
        int a = Integer.parseInt(st.nextToken());

        // 합을 구해야 하는 횟수 b
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[a+1][a+1];

        for (int i = 1; i <= a; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= a; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 dp 배열 생성
        int[][] dp = new int[a+1][a+1];

        // 1,1에서 해당 좌표까지의 합을 가진 dp 배열로 만들기
        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= a; j++) {
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        // 구간합 구하기
        for (int i = 0; i < b; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];

            bw.write(sum+"\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}