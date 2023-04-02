import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());


        // x가 3으로 나누어 떨어지면 3으로 나눈다
        // x가 2로 나누어 떨어지면 2로 나눈다
        // 1을 뺀다

        // 2  3  4(/2 + dp[2])  5(-1 +dp[4]) 6(/3 + dp[2]) 7(-1 +dp[6]) 8(/2+dp[4])
        // 1  1  2
        // 10
        // dp[9] + 1
        // dp[5] + 1

        // 7 8 9

        // 15 -> 5 -> 4 -> 2 -> 1
        // 15 -> 14 -> 7 -> 6 -> 2 -> 1

        int max = 100000;
        int[] dp = new int[num+1];

        dp[1] = 0;

        for (int i = 2; i <= num; i++){
            if (i%3 == 0){
                if (i%2 == 0){
                    dp[i] = Math.min(dp[i/3],Math.min(dp[i/2],dp[i-1]))+1;
                }
                else {
                    dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                }
            }
            else if(i%2 == 0){
                dp[i] = Math.min(dp[i/2],dp[i-1])+1;
            }
            else{
                dp[i] = dp[i-1] + 1;
            }
        }

        bw.write(dp[num]+"");

        bw.flush();
        br.close();
        bw.close();
    }

}
