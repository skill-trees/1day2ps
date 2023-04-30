
import java.util.Scanner;

public class 그림 {
    static int n, m, cnt;
    static int[][] map;
    static int[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    cnt = 1;
                    result++;
                    DFS(i, j);
                    max = Math.max(cnt, max);
                }
            }
        }
        System.out.println(result);
        System.out.println(max);

    }

    public static void DFS(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= n || my >= m || mx < 0 || my < 0)
                continue;
            if (visited[mx][my] == 0 && map[mx][my] == 1) {
                visited[mx][my] = 1;
                cnt += 1;
                DFS(mx, my);
            }
        }
        return;
    }
}
