package algorithm.backjoon.DP;

import java.io.*;
import java.util.*;

public class 구간합구하기5 {

  // TODO https://velog.io/@isohyeon/Java-%EB%B0%B1%EC%A4%80-11660-%EA%B5%AC%EA%B0%84-%ED%95%A9-%EA%B5%AC%ED%95%98%EA%B8%B0-5
  
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  // N X N 크기의 표
  // M 구해야 하는 횟수
  // Dy 합 배열
  static int N, M;
  static int[][] arr, Dy;

  static void solution () {
    N = scan.nextInt();
    M = scan.nextInt();

    // 1. N X N 크기의 표 생성
    arr = new int[N + 1][N + 1];
    Dy = new int[N + 1][N + 1];

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        Dy[i][j] = Dy[i - 1][j] + Dy[i][j - 1] - Dy[i - 1][j - 1] + scan.nextInt();
      }
    }


    // 2. 전체 합 배열에서 해당 구간 만큼의 합 구하기
    for(int i = 0; i < M; i++) {
      int x1 = scan.nextInt(),
      y1 = scan.nextInt(),
      x2 = scan.nextInt(),
      y2 = scan.nextInt();

      int sum = Dy[x2][y2] - Dy[x1 - 1][y2] - Dy[x2][y1 - 1] + Dy[x1 - 1][y1 - 1];
      sb.append(sum).append("\n");
    }

    System.out.println(sb.toString());
  }

  public static void main(String[] args) throws IOException {
    solution();
  }
}

