package 다이나믹프로그래밍;

import java.util.Scanner;

public class 상자넣기 {
	static int[] dp;
	static int[] list;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new int[n+1];
		list=new int[n+1];
		for(int i=1;i<=n;i++){
			list[i]=sc.nextInt();

		}

		for(int i=1;i<=n;i++){
			LIS(i);
		}

		int result=0;
		for(int i=0;i<n+1;i++){
			result=Math.max(result,dp[i]);
		}

		System.out.println(result);


	}
	public static int LIS(int n){
		if(dp[n]==0){
			dp[n]=1;

			for(int i=n-1;i>0;i--){
				if(list[i]<list[n]){
					dp[n]=Math.max(dp[n],LIS(i)+1);
				}
			}
		}
		return dp[n];

	}
}
