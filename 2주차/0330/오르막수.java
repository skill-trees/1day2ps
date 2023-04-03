package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());

		int[][] d=new int[1001][10];

		for(int i=0;i<10;i++){
			d[1][i]=1;
		}


		for(int i=2;i<=N;i++){
			for(int j=0;j<10;j++){
				for(int k=j;k<10;k++){
					d[i][j]+=d[i-1][k];
					d[i][j]%=10007;
				}
			}
		}

		int result=0;
		for(int j=0;j<10;j++){
			result+=(d[N][j]%10007);
		}

		System.out.println(result%10007);
	}
}
