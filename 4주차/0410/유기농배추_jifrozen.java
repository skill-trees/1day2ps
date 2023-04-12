package 4주차.0410;

import java.util.Scanner;

public class 유기농배추 {
	static int cnt=0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static int[][] visited;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
			int cnt=0;
			M=sc.nextInt();
			N=sc.nextInt();
			map=new int[N][M];
			visited=new int[N][M];
			int K=sc.nextInt();
			for(int i=0;i<K;i++){
				int X=sc.nextInt();
				int Y=sc.nextInt();
				map[Y][X]=1;
			}

			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(map[i][j]==1){
						if(DFS(i,j)){
							cnt++;
						}
					}
				}
			}

			System.out.println(cnt);
		}

	}
	public static boolean DFS(int x,int y){
		if(visited[x][y]==0&&map[x][y]==1){
			visited[x][y]=1;
			for(int i=0;i<4;i++){
				if(x+dx[i]<0||x+dx[i]>=N||y+dy[i]<0||y+dy[i]>=M){
					continue;
				}
				int mx=x+dx[i];
				int my=y+dy[i];
				if(visited[mx][my]==0&&map[mx][my]==1){
					DFS(mx,my);
				}
			}
			return true;
		}
		return false;
	}
}
