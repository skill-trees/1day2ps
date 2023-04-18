import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int N;
  static int[] Dy;

  static void input() {
    N = scan.nextInt();
    Dy = new int[N + 2];
  }

  static void solution() {
    // 1. 초기값 구하기
    Dy[1] = 1;
    Dy[2] = 2;

    // 2. Dy 배열
    for(int i = 3; i <= N; i++) {
      Dy[i] = (Dy[i - 2] + Dy[i - 1]) % 10007;
    }

    System.out.println(Dy[N] % 10007);
  }

  public static void main(String[] args) {
    input();
    solution();
  }
}
