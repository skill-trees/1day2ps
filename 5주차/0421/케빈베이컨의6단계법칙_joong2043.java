import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static final int INF = (int) 1e9;
    static int[][] arr;
    static int[] visit;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다.
        // 케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.

        // 천민호, 이강호 같은 학교 다니는 사이
        // 천민호와 최백준은 백준 온라인 저지를 통해 알게 되었다.

        // 1은 2까지 3을 통해 2단계 만에, 3까지 1단계 4까지 1단계, 5까지 4를 통해 2단계 만에 알 수 있다.

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++){
            for (int j =1; j <= n; j++){
                if (i==j){
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 점화식을 사용해서 플로이드 워셜 알고리즘
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n ; i++){
                for (int j =1; j <= n; j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
                }
            }
        }

        int minNum = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 1; i <= n; i++){
            int cnt = 0;
            for (int j =1; j <= n; j++){
                if (arr[i][j] == 0){
                    continue;
                }

                cnt+=arr[i][j];
            }

            if (cnt < minNum){
                minNum = cnt;
                index = i;
            }
        }

        bw.write(index+"");

        bw.flush();
        br.close();
        bw.close();

    }
}