import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2 * N 크기의 직사각형을 1 * 2, 2 * 1 타일로 채우는 방법의 수

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];
        for (int i = 1; i <= num; i++){
            if (i == 1 || i ==2){
                dp[i] = i;
                continue;
            }

            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        bw.write(dp[num]+"");

        bw.flush();
        br.close();
        bw.close();
    }

}