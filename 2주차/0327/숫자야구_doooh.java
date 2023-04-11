import java.io.*;
import java.util.*;

public class Main {

  public static class Node {
    String data;
    int strike;
    int ball;

    public Node(String data, int strike, int ball) {
      this.data = data;
      this.strike = strike;
      this.ball = ball;
    }
  }

  static FastReader scan = new FastReader();
  static Node[] games;
  static int N, count = 0;

  static void input() {
    N = scan.nextInt();
    games = new Node[N];

    for(int i = 0; i < N; i++) {
      games[i] = new Node(scan.next(), scan.nextInt(), scan.nextInt());
    }
  }


  static void solution() {
    for(int num = 111; num < 1000; num++) {
      String num1 = String.valueOf(num);
      if(!validation(num1)) continue;


      int temp = 0;

      // 2. 답지와 비교하며 정답 찾기
      for(int i = 0; i < N; i++) {
        String num2 = games[i].data;

        if(strike(num1, num2) == games[i].strike &&
            ball(num1, num2) == games[i].ball) {
          temp++;
        }
      }

      // 3. 정답을 찾으면 정답 카운트 증가
      if(temp == N) count++;
    }
  }

  // 1. 서로 다른 세 자리 수 && 0 이 있는지 검사
  static boolean validation(String num) {
    if(num.charAt(0) != num.charAt(1) &&
       num.charAt(1) != num.charAt(2) &&
       num.charAt(0) != num.charAt(2) &&
       num.charAt(0) != '0' &&
       num.charAt(1) != '0' &&
       num.charAt(2) != '0'
    ) return true;

    return false;
  }

  static int strike(String a, String b) {
    int scnt = 0;

    if(a.charAt(0) == b.charAt(0)) scnt++;
    if(a.charAt(1) == b.charAt(1)) scnt++;
    if(a.charAt(2) == b.charAt(2)) scnt++;

    return scnt;
  }

  static int ball(String a, String b) {
    int bcnt = 0;

    if(a.charAt(0) != b.charAt(0) && a.contains(String.valueOf(b.charAt(0)))) bcnt++;
    if(a.charAt(1) != b.charAt(1) && a.contains(String.valueOf(b.charAt(1)))) bcnt++;
    if(a.charAt(2) != b.charAt(2) && a.contains(String.valueOf(b.charAt(2)))) bcnt++;

    return bcnt;
  }

  public static void main(String[] args) {
    input();
    solution();

    System.out.println(count);
  }
}
