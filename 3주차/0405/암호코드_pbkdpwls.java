import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int len = number.length();
        int arr[] = new int[len+1];
        int dp[] = new int[len+1];

        // 2 5 1 1 4
        for (int i=0;i<len;i++){
            arr[i+1] = number.charAt(i)-'0';
        }

        // 2
        dp[0] = 1;

        for(int i=1;i<=len;i++){
            if(arr[i]!=0){
                dp[i] = (dp[i] + dp[i-1]) % 1000000;
            }

            int temp = arr[i] + arr[i-1]*10; // 두자리수
            if(10<=temp && temp<=26){ // 두자리수가 1~26일 때
                dp[i] = (dp[i]+dp[i-2]) % 1000000;
            }
        }

        System.out.println(dp[len]% 1000000);
    }
}
