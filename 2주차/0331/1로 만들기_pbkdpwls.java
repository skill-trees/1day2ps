import java.io.*;
import java.lang.Math;

public class makeone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        dp[2] = 1;
        dp[3] = 1;

        for (int i=4;i<n+1;i++) {
            dp[i] = dp[i-1] + 1; // 1을 먼저 뺀다.

            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i/2]+1); // 1을 뺀 것 vs 2로 나누는 것
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i], dp[i/3]+1); // 1을 뺀 것 vs 3으로 나누는 것
            }
        }

        System.out.println(dp[n]);
    }
}
