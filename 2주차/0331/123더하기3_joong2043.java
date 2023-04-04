import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        // dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
        // 1 + 3
        // 2 + 2
        // 3 + 1

        // 1 + 1 + 1
        // 2 + 1
        // 1 + 2
        // 3

        int max = 1000000;
        long[] dp = new long[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0 ; i < num ; i++){
            int n = Integer.parseInt(br.readLine());

            for (int j = 4; j <= n; j++){
                dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;
            }

            bw.write(dp[n]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
