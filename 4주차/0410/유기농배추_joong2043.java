import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요
        // 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;

            arr = new int[m][n];
            visit = new boolean[m][n];

            for (int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            for (int j = 0; j < m; j++){
                for (int r = 0; r <n; r++){
                    if (arr[j][r] == 1 && !visit[j][r]){
                        bfs(j,r);
                        count++;
                    }
                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int x, int y){

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x,y));

        while (!queue.isEmpty()) {

            Point queuePoint = queue.poll();
            x = queuePoint.x;
            y = queuePoint.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) {
                    continue;
                }

                if (!visit[nx][ny] && arr[nx][ny] == 1){
                    queue.add(new Point(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
