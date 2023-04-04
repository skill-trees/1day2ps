import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int N;
  static int[] info, answer;
  static boolean[] visited;

  static void input() {
    N = scan.nextInt();
    info = new int[N];
    answer = new int[N];
    visited = new boolean[N];

    for(int i = 0; i < N; i++) {
      info[i] = scan.nextInt();
    }
  }

  static void solution() {

    for(int i = 1; i <= N; i++){
      int left = 0;

      for(int j = 0; j < N; j++) {
        if(!visited[j]) {
          if(left == info[i - 1]) {
            visited[j] = true;
            answer[j] = i;
            break;
          }
          else left++;
        }
      }
    }

    for(int i = 0; i < N; i++) {
      sb.append(answer[i]).append(" ");
    }
  }

  public static void main(String[] args) {
   input();
   solution();
   System.out.println(sb.toString());
  }
}
