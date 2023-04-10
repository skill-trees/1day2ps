
import java.util.Scanner;

public class 퇴사_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] time = new int[N + 1];
        int[] p = new int[N + 1];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
            int t = time[i] + i;
            if (t <= N + 1) {
                dp[t] = Math.max(dp[t], p[i] + max);
            }
        }

        int result = 0;
        for (int i = 1; i <= N + 1; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
