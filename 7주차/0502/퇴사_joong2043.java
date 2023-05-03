import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];

        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++){
            int day = t[i] + i; // 1일 + 3 = 3일에 끝남

            if (day <= n) {
                dp[day] = Math.max(dp[i] + p[i], dp[day]);
            }

            dp[i+1] = Math.max(dp[i+1],dp[i]);

        }

        bw.write(dp[n]+"");

        bw.flush();
        bw.close();
        br.close();
    }

}