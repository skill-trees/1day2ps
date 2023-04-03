import java.io.*;
import java.util.*;

public class wallpaper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int calendar[] = new int[367];

        // 증감 배열을 이용하여 풀이
        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 시작지점 +1, 끝나는 다음 지점 +1
            calendar[start] += 1;
            calendar[end+1] -= 1;
        }

        int answer = 0;
        int height = 0;
        int width = 0;

        // 일자 : 2  3  4  5  6  7  8  9  10  11 12 13
        // 증감 : 1  0  1  1 -1  0 -1  0  -1  1  1  -2
        // 높이 : 1  1  2  3  2  2  1  1   0  1  2   0

        for (int i=1;i<367;i++) {
            calendar[i] += calendar[i-1]; // 높이 구하기
            if (calendar[i]==0) { // 높이가 0이면 면적 구하기
                answer += width*height;
                width = 0;
                height = 0;
            }
            else {
                width += 1;
                height = Math.max(height, calendar[i]); // 높이 최대값
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}
