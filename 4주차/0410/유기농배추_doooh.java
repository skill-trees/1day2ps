import java.util.*;
import java.io.*;

public class 유기농배추 {

  static FastReader scan = new FastReader();
  static int[][] map;
  static boolean[][] visited;
  static int count;
  static int M, N, K;

  // 상 하 좌 우
  static int[][] dxdy = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  static void input() {
    M = scan.nextInt();
    N = scan.nextInt();
    K = scan.nextInt();

    map = new int[M + 1][N + 1];
    visited = new boolean[M + 1][N + 1];

    while(K --> 0) {
      int X = scan.nextInt(), Y = scan.nextInt();
      map[X][Y] = 1;
    }
  }


  static void dfs(int x, int y) {
    visited[x][y] = true;

    for(int i = 0; i < 4; i++) {
      int tx = x + dxdy[i][0], ty = y + dxdy[i][1];

      if(0 <= tx && tx < M &&
         0 <= ty && ty < N &&
         map[tx][ty] == 1 &&
         !visited[tx][ty]) {
         dfs(tx, ty);
      }
    }
  }

  static void solution() {
    count = 0;

    for(int i = 0; i < M; i++) {
      for(int j = 0; j < N; j++) {
        if(map[i][j] == 1 && !visited[i][j]){
          dfs(i, j);
          count++;
        }
      }
    }

    System.out.println(count);
  }

  public static void main(String[] args) {
    int T = scan.nextInt();

    while(T --> 0) {
     input();
     solution();
    }
  }
}
