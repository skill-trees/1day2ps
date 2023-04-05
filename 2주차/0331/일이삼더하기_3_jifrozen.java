package 다이나믹프로그래밍;

import java.util.Scanner;

public class 일이삼더하기_3 {
	public static void main(String[] args) {
		long[] dp=new long[1000001];
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		StringBuilder sb=new StringBuilder();
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;

		for(int i=4;i<1000001;i++){
			dp[i]=((dp[i-1])+(dp[i-2])+(dp[i-3]))%1000000009;
		}
		//dp[4]=7
		//dp[5]=13
		//dp[6]=44
		while(T-->0){
			int n=sc.nextInt();
			sb.append(dp[n]+"\n");
		}

		System.out.print(sb.toString());
	}
}
