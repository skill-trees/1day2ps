import java.io.*;
import java.util.*;

public class retire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        int max = 0;

        for (int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);

            int ni = i + T[i];
            if (ni <= N) {
                dp[ni] = Math.max(dp[ni], max + P[i]);
            }

            for (int t : dp) {
                System.out.print(t + " ");
            }
            System.out.println();
        }

        System.out.println(max);
    }
}
