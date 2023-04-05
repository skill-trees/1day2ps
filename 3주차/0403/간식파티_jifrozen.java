package 3주차.0403;


import java.util.Scanner;

public class 간식파티 {
	static int[] list;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		list=new int[N];
		dp=new int[N];
		for(int i=0;i<N;i++){
			list[i]=sc.nextInt();
		}

		for(int i=0;i<N;i++){
			LIS(i);
		}

		int result=0;
		for(int i=0;i<N;i++){
			result=Math.max(result,dp[i]);
		}

		System.out.println(result);

	}
	public static int LIS(int n){
		if(dp[n] == 0) {
			dp[n] = list[n];

			for (int i = 0; i <n; i++) {
				if (list[i] < list[n]) {
					dp[n] = Math.max(dp[n], LIS(i) + list[n]);
				}
			}
		}
		return dp[n];
	}
}
