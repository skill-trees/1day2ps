import java.util.Arrays;
import java.util.Scanner;

public class prefixsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + sc.nextInt();
            }
        }

        for(int i=0;i<M;i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
        }
    }
}
