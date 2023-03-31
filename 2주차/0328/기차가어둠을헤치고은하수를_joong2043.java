
import java.awt.print.Pageable;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 기차가 어둠을 헤치고 은하수를 건넌다
        // 기차는 10개의 일렬로 된 좌석이 있고, 한 개의 좌석에는 한 명의 사람이 탈 수 있다.

        // 기차의 번호를 1번부터 N번으로 매길 때, 어떠한 기차에 대한여 M개의 명령이 주어진다.

        // 명령의 종류는 4가지
        // 1 i x : i 번째 기차에 x번째 좌석에 사람을 태워라. 이미 사람이 타있다면, 아무런 행동을 하지 않는다
        // 2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그 자리에 앉아있지 않았다면 아무런 행동을 하지 않는다
        // 3 i : i번째 기차에 앉아있는 승객들이 모두 한 칸씩 뒤로 간다. k번째 앉은 사람은 k+1 번째로 이동하여 앉는다. 만약 2
        // 4 i :

        StringTokenizer st = new StringTokenizer(br.readLine());

        int trainNum = Integer.parseInt(st.nextToken());
        int commandNum = Integer.parseInt(st.nextToken());

        // 1 1 1 -> 1번째 기차에 1번째 좌석에 사람을 태워라. 이미 사람이 타있다면 아무런 행동을 하지 않는다
        // 1 1 2 -> 1번째 기차에 2번재 좌석에 사람을 태워라. 이미 사람이 타있다면 아무런 행동을 하지 않는다.
        // 2 1 1 -> 1번째 기차에 1번째 좌석에 앉은 사람은 하차한다.
        // 3 1 -> 1번째 기차에 앉아있는 승객들은 모두 한 칸씩 뒤로 간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다.
        // 4 1 -> 1번째 기차에 앉아있는 승객들이 모두 한 칸씩 앞으로 간다. k번째 앉은 사람은 k-1번째 자리로 이동하여 앉는다.

        // 이미 목록에 존재하는 기록이면 해당 기차는 은하수를 건널 수 없다.

        // 1 o
        // 1 o o
        // 2   o
        // 2   o o
        // 1 o o o

        arr = new int[trainNum+1][21];

        for (int i = 0; i < commandNum; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if (a == 1 || a ==2){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (a == 1){
                    arr[b][c] = 1;
                }
                else if(a == 2){
                    arr[b][c] = 0;
                }
            }
            else if(a == 3 || a == 4){
                int b = Integer.parseInt(st.nextToken());

                if (a == 3){
                    plusOneMove(b);
                }
                else if(a == 4){
                    minusOneMove(b);
                }
            }
        }

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 1 ; i < trainNum+1 ; i++){
            String temp="";
            for (int j = 1; j <= 20; j++){
                temp+=String.valueOf(arr[i][j]);
            }
            hashSet.add(temp);
        }

        bw.write(hashSet.size()+"");


        bw.flush();
        br.close();
        bw.close();
    }

    public static void plusOneMove(int num){
        for (int i = 19; i >= 1; i--){
            arr[num][i+1] = arr[num][i];
        }
        arr[num][1] = 0;
    }

    public static void minusOneMove(int num){
        for (int i = 2; i < 21; i++){
            arr[num][i-1] = arr[num][i];
        }
        arr[num][20] = 0;
    }


}
