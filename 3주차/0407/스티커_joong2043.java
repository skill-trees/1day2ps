import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        50 10 100 20 40
//        30 50 70 10 60      260
//        10 30 10 50 100 20 40
//        20 40 30 50 60 20 80      290

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int length = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][length];
            int[][] dp = new int[2][length];
            int index = -1;

            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < length; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 0; k < length; k++){
                for (int j = 0; j < 2; j++){
                    if (k==0){
                        dp[j][k] = arr[j][k];
                    }
                    else if(k==1){
                        if (j==0){
                            dp[j][k] = dp[j+1][k-1]+arr[j][k];
                        }
                        else{
                            dp[j][k] = dp[j-1][k-1]+arr[j][k];
                        }
                    }
                    else{
                        if (j==0){
                            dp[j][k] = Math.max(dp[j+1][k-1]+arr[j][k], dp[j+1][k-2]+arr[j][k]);
                        }
                        else{
                            dp[j][k] = Math.max(dp[j-1][k-1]+arr[j][k], dp[j-1][k-2]+arr[j][k]);
                        }

                    }
                }
            }

           bw.write(Math.max(dp[0][length-1],dp[1][length-1])+"\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }

}