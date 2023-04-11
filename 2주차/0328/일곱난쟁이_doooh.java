import java.io.*;
import java.util.*;

public class Main {
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int[] candidates = new int[9], results = new int[7], prints = new int[7];
  static boolean[] visited = new boolean[9];
  static void input() {
    for(int i = 0; i < 9; i++) {
      candidates[i] = scan.nextInt();
    }
  }

  static void dfs(int count) {
    if(count == 7) {
      int sum = 0;

      for (int i = 0; i < 7; i++) {
        sum += results[i];
      }

      if (sum == 100) {
        for (int i = 0; i < 7; i++) {
          prints[i] = results[i];
        }
      }


      return;
    }

    for(int i = 0; i < 9; i++) {
      if(!visited[i]) {
        visited[i] = true;
        results[count] = candidates[i];
        dfs(count + 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    input();
    dfs(0);

    Arrays.sort(prints);
    for(int i = 0; i < 7; i++) {
      sb.append(prints[i]).append("\n");
    }

    System.out.println(sb.toString());
  }
}
