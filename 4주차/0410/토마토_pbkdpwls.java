import java.util.*;

class Point{
    int row, col;
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class tomato {
    static int N,M;
    static int tomato[][];
    static boolean visited[][];
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, 1, -1, 0};
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        tomato = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j]==1 && visited[i][j]==false) {
                    queue.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(bfs());
    }
    public static int bfs(){
        while(!queue.isEmpty()) {
            answer++;
            Point point = queue.poll();
            int row = point.row;
            int col = point.col;

            for (int k = 0; k < 4; k++) {
                int x = row + dx[k];
                int y = col + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (tomato[x][y] == 0 && visited[x][y]==false) {
                        tomato[x][y] = tomato[row][col] + 1;
                        queue.add(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 0) { // 다 익지 못함
                    return -1;
                }
                result = Math.max(result, tomato[i][j]);
            }
        }

        return result - 1;
    }
}