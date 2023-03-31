
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 한 줄로 서기

        // 사람들의 키는 1부터 N까지 다르다

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // List 선언
        List<Integer> list = new ArrayList<>();

        // 뒤에서 부터 진행해서 큰 수가 먼저 리스트에 add
        // 해당 문자열의 값에 맞는 index에 리스트를 add
        for (int i = num; i>=1; i--){
            list.add(arr[i-1], i);
        }

        for (int n : list){
            bw.write(n+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}