import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[][] arr;
    static boolean[] visit;
    static int num;
    static int b;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 우리나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.

        num = Integer.parseInt(br.readLine());
        arr = new int[num+1][num+1];
        visit = new boolean[num+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[k][y] = arr[y][k] = 1;
        }

        dfs(a,0);

        if (answer == 0){
            bw.write(-1+"");
        }
        else {
            bw.write(answer + "");
        }


        bw.flush();
        br.close();
        bw.close();

    }

    public static void dfs(int n, int cnt){

        visit[n] = true;

        for (int i = 1; i <= num; i++){
            if (!visit[i] && arr[i][n] == 1){
                if (i==b){
                    answer = cnt+1;
                    return;
                }
                dfs(i, cnt+1);
            }
        }
    }

}