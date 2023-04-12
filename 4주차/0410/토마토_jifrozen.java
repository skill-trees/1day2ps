
import java.io.*;
import java.util.*;

public class 토마토 {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        Queue<Integer> dayQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    xq.offer(i);
                    yq.offer(j);
                    dayQ.offer(0);
                }
            }
        }
        int day = 0;
        while (!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();
            day = dayQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    xq.offer(nx);
                    yq.offer(ny);
                    dayQ.offer(day + 1);
                }
            }
        }
        boolean checkZero = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    checkZero = true;
                    break;
                }
            }
        }

        if (checkZero) {
            System.out.print(-1);
        } else {
            System.out.print(day);
        }
    }
}
