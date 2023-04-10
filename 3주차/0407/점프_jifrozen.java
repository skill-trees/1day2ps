package 다이나믹프로그래밍;
import java.util.*;
import java.io.*;

public class 점프 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n+1][n+1];
		long[][] dp=new long[n+1][n+1];
		StringTokenizer st;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=1;

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(i==n-1&&j==n-1){
					continue;
				}
				if(i+arr[i][j]<n){
					dp[i+arr[i][j]][j]+=dp[i][j];
				}
				if(j+arr[i][j]<n){
					dp[i][j+arr[i][j]]+=dp[i][j];
				}
			}
		}

		System.out.print(dp[n-1][n-1]);



	}
}
