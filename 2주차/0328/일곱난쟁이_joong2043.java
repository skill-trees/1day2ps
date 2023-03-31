
import java.awt.print.Pageable;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] arr;
    static boolean[] visit = new boolean[9];
    static int[] answer = new int[7];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기
        // 일곱 난쟁이의 키의 합이 100

        arr = new int[9];

        for (int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        Arrays.sort(answer);

        for (int i =0; i < 7; i++){
            bw.write(answer[i]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int level, int sum){
        if (level == 7){
            if (sum == 100){
                int idx = 0;
                for (int i =0 ; i< 9; i++){
                    if (visit[i]){
                        answer[idx++] = arr[i];
                    }
                }
                return;
            }
        }

        // 백트래킹
        for (int i = 0; i < 9; i++){
            if (!visit[i]) {
                visit[i] = true;
                dfs(level + 1, sum + arr[i]);
                visit[i] = false;
            }
        }

    }

}
