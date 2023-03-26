package 1day2ps.1주차.0324;

import java.util.Scanner;

public class 배열돌리기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T= sc.nextInt();
		StringBuilder sb=new StringBuilder();
		while(T-->0){
			int n=sc.nextInt();
			int d=sc.nextInt();
			int[][] map=new int[n][n];
			int[][] arr=new int[n][n];

			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					map[i][j]=sc.nextInt();
					arr[i][j]=map[i][j];
				}
			}
			int num=0;
			if(d>0) {
				num = d / 45;
			}else{
				num=8+d/45;
			}

			for(int i=0;i<num;i++){
				map=rotate(map,n);
			}

			for(int i=0;i<n;i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]==0){
						sb.append(arr[i][j]+" ");
					}else {
						sb.append(map[i][j] + " ");
					}
				}
				sb.append("\n");
			}

		}
		System.out.println(sb.toString());
	}

	public static int[][] rotate(int[][] map,int n){
		int[][] newMap=new int[n][n];
		int half=(n)/2;
		for(int i=0;i<n;i++){
			newMap[i][n-i-1]=map[i][half];
			newMap[i][half]=map[i][i];
			newMap[i][i]=map[half][i];
			newMap[half][n-i-1]=map[i][n-i-1];
		}
		return newMap;
	}
}
