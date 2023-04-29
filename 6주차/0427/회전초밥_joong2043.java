import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] eat = new int[d+1];

        int maxNum = 0;

        int start = 0;

        // 먼저 인덱스가 0에서 스타트 해서 k까지 초밥을 먹는 경우
        for(int i = start; i < k; i++){
            // 선택되지 않은 초밥의 경우 maxNum 값을 + 1
            if (eat[arr[i]] == 0){
                maxNum++;
            }
            eat[arr[i]] += 1;
        }

        int result = maxNum;

        // 이제 맨 앞에꺼를 빼주고 뒤 초밥 1개를 증가시켜주는 투포인터 계산 시작
        for (int i = 0; i < n; i++){
            if (result <= maxNum){
                if (eat[c] == 0){
                    result = maxNum + 1;
                }
                else{
                    result = maxNum;
                }
            }

            // 맨 앞의 초밥을 빼주는 과정
            // 만약 초밥이 1번만 선택된 거라면 maxNum을 하나 빼줘야 함
            if (eat[arr[i]] == 1){
                maxNum--;
            }
            eat[arr[i]]--;

            int j = (i+k) % n;
            if (eat[arr[j]] == 0){
                maxNum++;
            }
            eat[arr[j]]++;
        }

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
