package 1day2ps.1주차.0324;

import java.util.ArrayList;
import java.util.Scanner;

public class 지구온난화 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int R=sc.nextInt();
		int C=sc.nextInt();

		char[][] map=new char[R][C];

		for(int i=0;i<R;i++){
			String str=sc.next();
			for(int j=0;j<C;j++){
				map[i][j]=str.charAt(j);
			}
		}

		ArrayList<Integer> x=new ArrayList<>();
		ArrayList<Integer> y=new ArrayList<>();


		for(int i=0;i<R;i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='.'){
					continue;
				}
				int check=0;
				for(int k=0;k<4;k++){
					int mx=i+dx[k];
					int my=j+dy[k];
					if(mx<0||mx>=R||my<0||my>=C) {check++; continue;}
					if(map[mx][my]=='.') check++;
				}
				if(check>=3){
					x.add(i);
					y.add(j);
				}

			}
		}

		for(int i=0;i<x.size();i++){
			map[x.get(i)][y.get(i)]='.';
		}

		int col=Integer.MAX_VALUE;
		int row=Integer.MAX_VALUE;
		int col1=0;
		int row1=0;
		for(int i=0;i<R;i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='X'){
					row=Math.min(row,i);
					col=Math.min(col,j);
					row1=Math.max(row1,i);
					col1=Math.max(col1,j);
				}
			}
		}

		for(int i=row;i<=row1;i++){
			for(int j=col;j<=col1;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}
