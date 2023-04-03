
import java.awt.*;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{


    public static void main(String[] args) throws Exception{
//        long sTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0 1 2 3 4 5 6 7 8 9 -> 10
        // 00 01 02 03 04 05 06 07 08 09 .... 89 -> 10 + 9 + 8 + ... + 1 = 55
        // 00[] -> 10
        // 01[] -> 9
        // 02[] -> 8
        // 03[] -> 7
        // 09[] -> 1

        // 11[] -> 9
        // 12[] -> 8

        // (1+...+10) + (1 +... +9) + (1+....+8) + (1 +... +7) + (1 +...+ 6) + (1)
        // 55 + 45 +

        // dp[2] = for(dp[1] + dp[1]-1 + dp[1] - 2 + ... + 1)

        //
        // 10 * 1 + 8 * 2 + 7 * 3 + .. + 1 * 9

        // dp [1,1,1, 1, 1, 1, 1, 1, 1, 1]
        //    [1,2,3, 4, 5, 6, 7, 8, 9,10]
        //    [1,3,6,10,15,21,28,36,45,55]

        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[num+1][11];

        dp[1] = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        // 왼쪽 원소와 위 원소의 합을 가진 2차원 dp 배열 만들기
        for (int i = 2; i <= num; i++){
            dp[i][1] = 1;
            for (int j = 2; j <= 10; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                dp[i][j] = dp[i][j] % 10007;
            }
        }

        // 해당 행의 dp 합계 값 구하기
        bw.write(Arrays.stream(dp[num]).sum() % 10007+"");

        br.close();
        bw.flush();
        bw.close();

    }

}