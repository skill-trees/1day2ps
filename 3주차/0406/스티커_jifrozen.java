package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		while(T-->0){
			int n=Integer.parseInt(br.readLine());
			int[][] sticker=new int[2][n+1];
			int[][] d=new int[2][n+1];
			st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++){
				sticker[0][i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++){
				sticker[1][i]=Integer.parseInt(st.nextToken());
			}
			d[0][1]=sticker[0][1];
			d[1][1]=sticker[1][1];

			for(int i=2;i<=n;i++){
				d[0][i]=Math.max(d[1][i-1],d[1][i-2])+sticker[0][i];
				d[1][i]=Math.max(d[0][i-1],d[0][i-2])+sticker[1][i];
			}

			sb.append(Math.max(d[0][n],d[1][n])+"\n");
		}
		System.out.println(sb);
	}
}
