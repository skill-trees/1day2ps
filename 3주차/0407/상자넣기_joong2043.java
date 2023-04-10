import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N];

        Arrays.fill(dp, 1);

        int answer = 0;

        // 증가 확인 반복문
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        bw.write(answer+"");

        bw.flush();
        br.close();
        bw.close();
    }

}