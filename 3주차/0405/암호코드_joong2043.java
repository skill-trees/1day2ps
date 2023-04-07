import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();

        int[] dp = new int[num.length()+1];
        // 2 5 1 1 4
        // 2
        // [2, 5], [25]
        // [2, 5, 1], [25, 1], [2, 51](X)
        // [2, 5, 1, 1], [25, 1, 1], [2,51, 1](X), [2, 5, 11], [25, 11]
        // [2, 5, 1, 1, 4], [25, 1, 1, 4], [2, 51, 1, 4], [2, 5, 1, 14], [


        // 2
        // 2 5, 25
        // 2 5 2, 25 2,
        // 2 5 2 8, 25 2 8,

        int MOD = 1000000;

        dp[0] = 1;

        for (int i = 1; i <= num.length(); i++){
            int now = num.charAt(i-1) - '0';
            if (now >=1 && now <= 9){
                dp[i] += dp[i-1];
                dp[i] %= MOD;
            }

            if (i==1){
                continue;
            }

            int prev = num.charAt(i-2) - '0';

            if (prev == 0){
                continue;
            }

            int value = prev * 10 + now;

            if (value >= 10 && value <= 26){
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }

        bw.write(dp[num.length()]+"");

        bw.flush();
        br.close();
        bw.close();
    }
}