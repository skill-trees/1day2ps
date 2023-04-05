import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        // 전투력이 높은 병사를 내림차순
        // 15 11 4 8 5 2 4
        // 1  2  3 3 4 5 5

        int[] arr = new int[num];
        int[] dp = new int[num];


        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < num ; i++){
            dp[i] = arr[i];
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        Arrays.sort(dp);

        bw.write(dp[num-1]+"");

        bw.flush();
        br.close();
        bw.close();
    }


}