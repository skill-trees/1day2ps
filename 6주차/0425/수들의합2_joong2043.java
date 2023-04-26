import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // sum >= m or e==n이면 sum에서 a[s]를 빼고 나서 s를 증가

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        int start = 0;
        int end = 0;

        int sum = 0;

        while (true){
            if (sum >= m){
                sum -= arr[start++];
            }
            else if (end == n){
                break;
            }
            else{
                sum+=arr[end++];
            }

            if (sum == m){
                cnt++;
            }
        }

        bw.write(cnt+"");

        bw.close();
        br.close();
    }

}