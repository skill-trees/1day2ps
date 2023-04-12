import java.util.Scanner;
import static java.lang.Math.min;

// 백준 삼각그래프 4883번 DP 풀이
public class triangular_graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;

        while(true){
            int N = sc.nextInt(); // 그래프의 행 수
            if(N==0) break; // 마지막 입력

            int arr[][] = new int[N][3];
            int dp[][] = new int[N][3];

            for (int i=0;i<N;i++) {
                for(int j=0;j<3;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 정수 조건임으로 음수일 경우 주의
            // 두번째 행 값 구하기 - dp[1][0], dp[1][1], dp[1][2]

            // dp[1][0]
            dp[1][0] = arr[1][0] + arr[0][1];

            // dp[1][1]
            int temp =  min(dp[1][0], arr[0][1]); // 2행 1열까지의 값 vs 1행 2열(직통)
            temp = min(temp,arr[0][2]+arr[0][1]); // min vs 1행 3열까지의 값
            dp[1][1] = arr[1][1] + temp;

            // dp[1][2]
            temp =  min(dp[1][1], arr[0][1]); // 2행 2열까지의 값 vs 1행 2열(직통)
            temp = min(temp,arr[0][1]+arr[0][2]); // min vs 1행 3열까지의 값
            dp[1][2] = arr[1][2] + temp;

            for (int i=2;i<N;i++){
                for(int j=0;j<3;j++){
                    int min_value;
                    if (j==0) { // 1열
                        min_value = min(dp[i-1][0], dp[i-1][1]); // 이전행 1열 vs 이전행 2열
                    }
                    else if (j==1){ // 2열
                        min_value = min(dp[i-1][0], dp[i-1][1]); // 이전행 1열 vs 이전행 2열
                        min_value = min(min_value, dp[i-1][2]); // min vs 이전행 3열
                        min_value = min(min_value, dp[i][0]); // min vs 같은행 1열
                    }
                    else { // 3열
                        min_value = min(dp[i-1][1], dp[i-1][2]); // 이전행 2열 vs 이전행 3열
                        min_value = min(min_value, dp[i][1]); // min vs 같은행 2열
                    }

                    dp[i][j] = arr[i][j] + min_value;
                }
            }

            System.out.println(t+". "+dp[N-1][1]);
            t++;
        }
    }
}
