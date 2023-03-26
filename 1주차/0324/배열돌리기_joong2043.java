
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int len;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        크기가 n x n인 2차원 정수 배열 X가 있다. (n은 홀수)
//
//        X를 45° 의 배수만큼 시계방향 혹은 반시계방향으로 돌리려고 한다.
//        X를 시계 방향으로 45° 돌리면 아래와 같은 연산이 동시에 X에 적용되어야 한다:
//
//        X의 주 대각선을 ((1,1), (2,2), …, (n, n)) 가운데 열 ((n+1)/2 번째 열)로 옮긴다.

//        X의 가운데 열을 X의 부 대각선으로 ((n, 1), (n-1, 2), …, (1, n)) 옮긴다.

//        X의 부 대각선을 X의 가운데 행 ((n+1)/2번째 행)으로 옮긴다.

//        X의 가운데 행을 X의 주 대각선으로 옮긴다.

//        위 네 가지 경우 모두 원소의 기존 순서는 유지 되어야 한다.

//        X의 다른 원소의 위치는 변하지 않는다.

//        반시계 방향으로 45° 돌리는 경우도 위와 비슷하게 정의된다.
//
//        예를 들어, 아래 그림 중앙에 5x5 배열 X가 있고,
//        이 배열을 시계방향 혹은 반시계방향으로 45° 돌렸을 때의 결과가 우측 그리고 좌측에 있다.
//        굵은 원소는 주 대각선 / 중간 열 / 부 대각선 / 중간 행에 위치한 원소이다.

        // 총 배열 개수
        int num = Integer.parseInt(br.readLine());

        // StringBuilder 선언
        StringBuilder sb = new StringBuilder();


        for (int q = 0 ; q < num ; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());

            map = new int[len][len];

            int[][] arr = new int[len][len];

            int angle = Integer.parseInt(st.nextToken());

            // angle 45로 나눈 값 = r
            int r = angle/45;

            for (int i = 0 ; i < len; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < len; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j] = value;
                    arr[i][j] = value;
                }
            }

            for (int i = 0; i < Math.abs(r); i++){
                if (angle > 0){
                    rotateRight();
                }
                else{
                    rotateLeft();
                }
            }

            for (int i = 0; i < len; i++){
                for (int j = 0; j < len; j++){
                    // 만약 map에 요소가 0일 경우 arr에 있는 값을 그대로 가져오기
                    if (map[i][j] == 0){
                        map[i][j] = arr[i][j];
                    }
                    sb.append(map[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void rotateRight(){
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++){
            temp[i][len/2] = map[i][i];
            temp[i][i] = map[len/2][i];
            temp[len/2][i] = map[len-i-1][i];
            temp[len-i-1][i] = map[len-i-1][len/2];
        }
        map = temp;
    }

    public static void rotateLeft(){
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++){
            temp[i][len/2] = map[i][len-i-1];
            temp[i][i] = map[i][len/2];
            temp[len/2][i] = map[i][i];
            temp[len-i-1][i] = map[len/2][i];
        }
        map = temp;
    }


}
