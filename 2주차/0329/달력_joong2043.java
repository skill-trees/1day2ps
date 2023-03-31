import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[][] nums = new int[num][2];

        // 행 길이를 367로 한 이유 -> 직사각형 넓이를 만들 때 0을 가진 열을 기준으로 할 거라서
        //                            맨 마지막 열을 전부 0으로 만들어야
        //                            마지막 직사각형 처리가 가능
        int[][] arr = new int[1000][367];

        // 높이 측정용 배열
        int[] height = new int[367];

        for (int i = 0 ; i < num; i++) {
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < num; i++) {
            // 일정을 넣는 행 = cnt
            int cnt = 0;
            int start = nums[i][0];
            int end = nums[i][1];

            for (int j = start; j <= end; j++){
                if (arr[cnt][j] == 1){
                    cnt++;
                    j = nums[i][0]-1;
                }
                else {
                    arr[cnt][j] = 1;
                }
            }
        }

        int max = 0;
        int sum = 0;
        int width = 0;
        for (int i = 1; i <= 366; i++){

            for (int j = 0; j <1000; j++){
                if (arr[j][i] == 1){
                    height[i] +=1;
                }
            }

            if (height[i] == 0){
                // 높이 배열의 값이 0이라면 직사각형 넓이 값을 구해야 하므로
                // width * max 값 더해줌
                sum += width * max;
                // max값과 width값 초기화
                max = 0;
                width = 0;
            }
            else {
                if (height[i] != 0) {
                    // 만약 높이 배열의 값이 0이 아니라면 max 값 설정
                    max = Math.max(height[i], max);
                    // 만약 높이 배열의 값이 0이 아니라면 width 값 + 1
                    width++;
                }
            }
        }

        bw.write(sum+"");

        bw.flush();
        br.close();
        bw.close();
    }

}
