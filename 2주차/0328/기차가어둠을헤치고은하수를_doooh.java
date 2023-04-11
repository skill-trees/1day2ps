import java.io.*;
import java.util.*;

public class 기차가어둠을헤치고은하수를 {

  static FastReader scan = new FastReader();
  static int N, M;
  static int[][] trains;

  static void input() {
    // N = 기차 개수 , M = 명령 개수
    N = scan.nextInt();
    M = scan.nextInt();

    trains = new int[N][21];
  }

  static void solution() {

    // 1. 명령에 따라 Train 배열에 승객 승하차 및 이동 실행
    for(int i = 0; i < M; i++) {
      int command = scan.nextInt(), num = scan.nextInt();

      if(command == 1 || command == 2) {
        int index = scan.nextInt();

        if(command == 1) { // num 번째 기차에 index 번째 사람을 승차
          trains[num - 1][index - 1] = 1;

        } else if(command == 2) { // num 번째 기차에 index 번째 사람 하차
          trains[num - 1][index - 1] = 0;
        }
      }

      else if(command == 3) { // num 번째 기차 승객 한 칸씩 뒤
        for(int c = 18; c >= 0; c--) {
          trains[num - 1][c + 1] = trains[num - 1][c];
        }
        trains[num - 1][0] = 0;

      } else if(command == 4) { // num 번째 기차 승객 한 칸씩 앞
        for(int c = 1; c < 20; c++) {
          trains[num - 1][c - 1] = trains[num - 1][c];
        }
        trains[num - 1][19] = 0;
      }
    }

    // 2. N 개의 기차 가운데 은하수를 건널 수 있는 기차 (중복 제거)
    HashSet<String> cases = new HashSet<>();

    for(int i = 0; i < N; i++) {
      cases.add(Arrays.toString(trains[i]));
    }


    // 3. HashSet 사이즈 출력
    System.out.println(cases.size());
  }

  public static void main(String[] args) {
    input();
    solution();
  }
}