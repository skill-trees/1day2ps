import java.util.*;
import java.io.*;

public class Main {
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int N;
  static int[][] Dy;

  static void input() {
    N = scan.nextInt();
    Dy = new int[N + 1][10];
  }

  static void solve () {
    // 초기값 구하기
    // Dy
    //     0 1 2 3 4 5 6 7 8 9
    // 0 :
    // 1 : 1 1 1 1 1 1 1 1 1 1
    for(int i = 0; i < 10; i++) {
      Dy[1][i] = 1;
    }

    // 점화식을 토대로 Dy 배열 채우기
    // Dy
    //     0 1 2 3 4 5 6 7 8 9
    // 0 :
    // 1 : 1 1 1 1 1 1 1 1 1 1
    // 2 : 1 2 3 4 5 6 7 8 9 10

    for(int len = 2; len <= N; len++) {
      for(int i = 0; i < 10; i++) {
        for(int prev = 0; prev <= i; prev ++) {
          Dy[len][i] += Dy[len - 1][prev];
          Dy[len][i] %= 10007;
        }
      }
    }


    // Dy배열로 정답 계산하기
    int ans = 0;
    for(int i = 0; i < 10; i++) {
      ans += Dy[N][i];
      ans %= 10007;
    }

    System.out.println(ans);
  }

  public static void main(String[] args) {
    input();
    solve();
  }
}
