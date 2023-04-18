package 5주차.0418;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
	static int[] dx={-2,-1,1,2,2,1,-1,-2};
	static int[] dy={-1,-2,-2,-1,1,2,2,1};

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
			int l=sc.nextInt();
			int[][] map=new int[l+1][l+1];
			int[][] visited=new int[l+1][l+1];
			int sx=sc.nextInt();
			int sy=sc.nextInt();
			int ex=sc.nextInt();
			int ey=sc.nextInt();
			visited[sx][sy]=1;
			Queue<Integer> xq=new LinkedList<>();
			Queue<Integer> yq=new LinkedList<>();
			xq.offer(sx);
			yq.offer(sy);
			while(!xq.isEmpty()) {
				int x = xq.poll();
				int y = yq.poll();
				for (int i = 0; i < 8; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (mx >= 0 && my >= 0 && mx < l && my < l) {
						if (visited[mx][my] == 0) {
							visited[mx][my] += visited[x][y]+1;
							xq.offer(mx);
							yq.offer(my);
						}
					}
				}
			}

			System.out.println(visited[ex][ey]-1);

		}
	}
}
