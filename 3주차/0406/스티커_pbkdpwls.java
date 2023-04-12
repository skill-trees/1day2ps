import java.io.*;

public class sticker {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for(int j=0;j<2;j++){
                String[] input = br.readLine().split(" ");
                for(int k=1;k<=N;k++){
                    stickers[j][k] = Integer.parseInt(input[k-1]);
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int j=2;j<=N;j++){
                // DP 점화식 : 현재 요소에서 왼쪽 대각선 아래, 왼쪽 대각선 아래 왼쪽 두 가지 선택지 중 큰 것 (첫번째 행일때, 두번째 행은 반대)
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
