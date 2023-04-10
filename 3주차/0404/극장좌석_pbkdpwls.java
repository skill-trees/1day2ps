import java.util.Scanner;

public class cinema_seat {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int dp[] = new int[n+2];
        int vip[] = new int[m];

        for(int i=0;i<m;i++){
            vip[i] = sc.nextInt();
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        int temp = 0;
        int answer = 1;
        for(int i=0;i<m;i++) {
            answer*=dp[vip[i]-temp-1];
            temp = vip[i];
        }
        answer*=dp[n-temp];

        System.out.println(answer);
    }
}
