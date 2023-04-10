import java.util.Scanner;

import static java.lang.Math.max;

public class snack_party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[N+1];
        int arr[] = new int[N+1];

        for(int i=0;i<N;i++) {
            arr[i]=sc.nextInt();
        }

        dp[0] = arr[0];
        int answer = dp[0];

        for(int i=1;i<N;i++){
            dp[i] = arr[i]; // 현재 간식 먹었을 떄
            for (int j=0;j<i;j++){
                if(arr[j]<arr[i]) { // 현재 간식 이전 값 계산
                    dp[i] = max(dp[i], dp[j]+arr[i]);
                }
            }
            answer = max(answer, dp[i]); // 최댓값 갱신
        }

        // 결과 출력
        System.out.println(answer);
    }
}
