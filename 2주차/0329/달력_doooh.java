import java.util.*;
import java.io.*;

public class Main {

  static FastReader scan = new FastReader();
  static int N;
  static int[] arr;

  static void input()  {
    N = scan.nextInt();
    arr = new int[366];

    for(int i = 0; i < N; i++) {
      int s = scan.nextInt();
      int e = scan.nextInt();

      for (int j = s; j <= e; j++) {
        arr[j]++;
      }
    }
  }

  static void solution() {

    int sum = 0;
    int maxHeight = 0;
    int width = 0;

    for (int i = 0; i <= 365; i++) {
      if (arr[i] == 0) {
        sum += maxHeight * width;
        maxHeight = width = 0;
        continue;
      }

      width++;
      maxHeight = Math.max(maxHeight, arr[i]);
    }

    sum += maxHeight * width;
    System.out.println(sum);
  }

  public static void main(String[] args) throws Exception {
    input();
    solution();
  }
}
