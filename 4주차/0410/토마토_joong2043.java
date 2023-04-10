import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visit;
    static int max = 0;
    static Queue<Dot> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 잘익은 토마토 익지 않은 토마토

        // 보관 후 하루가 지나면 익은 토마토들의 인접한 곳에 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        int count =0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == 1){
                    queue.add(new Dot(i,j,0));
                }
            }
        }

        count = bfs();
        boolean ans = true;

        for (int i = 0; i < n; i++){
            for (int j =0; j <m ;j++){
                if (arr[i][j] == 0){
                    ans = false;
                    break;
                }
            }
        }

        if (ans == false){
            bw.write(-1+"");
        }
        else {
            bw.write(count+"");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int bfs() {
        max = 0;

        while (!queue.isEmpty()) {

            Dot pollDot = queue.poll();

            max = Math.max(pollDot.cnt,max);

            for (int i = 0; i < 4; i++) {
                int nx = pollDot.x + dx[i];
                int ny = pollDot.y + dy[i];
                int ncnt = pollDot.cnt;

                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) {
                    continue;
                }

                if (!visit[nx][ny] && arr[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    arr[nx][ny] = 1;
                    queue.add(new Dot(nx, ny, ncnt+1));
                }
            }
        }

        return max;
    }

}

class Dot{
    int x;
    int y;
    int cnt;

    Dot(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
