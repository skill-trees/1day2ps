import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[][] arr;
    static boolean[][] visit;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int maxNum = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visit[i][j] && arr[i][j] ==1){
                    maxNum=Math.max(maxNum, bfs(i,j));
                    cnt++;
                }
            }
        }

        bw.write(cnt+"\n");
        bw.write(maxNum+"");

        bw.flush();
        br.close();
        bw.close();

    }

    public static int bfs(int a, int b){

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(a,b));
        visit[a][b] = true;
        int cnt = 1;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx <0 || ny <0 || nx>= n || ny >=m){
                    continue;
                }

                if (!visit[nx][ny] && arr[nx][ny] == 1){
                    visit[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}