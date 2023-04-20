import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] arr;
    static boolean[] visit;
    static int a, b;
    static int maxNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[a];
        visit = new boolean[a];

        for(int i = 0 ; i < a; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        bw.write(maxNum+"");

        bw.flush();
        br.close();
        bw.close();

    }

    public static void dfs(int sum, int level){

        if (level == 3){
            if (sum <= b) {
                maxNum = Math.max(maxNum, sum);
                return;
            }
        }

        for (int i = 0; i < a; i++){
            if(!visit[i]){
                visit[i] = true;
                if (sum+arr[i] <=b){
                    dfs(sum+arr[i], level+1);
                }

                visit[i] = false;
            }
        }
    }

}