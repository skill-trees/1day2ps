import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static int[] cards, results = new int[3];
  static boolean[] visited;
  static int N, M, answer = 0;

  static void dfs(int k) {
    if(k == 3) {
      int sum = 0;
      for(int i = 0; i < 3; i++) sum += results[i];
      if(sum <= M) answer = Math.max(answer, sum);
    } else {
      for(int i = k; i < N; i++) {
        if(!visited[i]) {
          visited[i] = true;
          results[k] = cards[i];
          dfs(k + 1);
          visited[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    N = scan.nextInt();
    M = scan.nextInt();

    cards = new int[N + 1];
    visited = new boolean[N + 1];

    for(int i = 0; i < N; i++) {
      cards[i] = scan.nextInt();
    }


    dfs(0);
    System.out.println(answer);
  }
}
