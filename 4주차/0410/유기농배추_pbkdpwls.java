import java.util.Scanner;

// 백준 유기농 배추 1012번 DFS 풀이
public class cabbage_bfs {
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, 1, -1, 0};
    static boolean[][] visited;
    static int N, M;
    static int[][] graph;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T!=0){
            N = sc.nextInt();
            M = sc.nextInt();
            int K = sc.nextInt();

            visited = new boolean[N][M];
            graph = new int[N][M];

            for(int i=0;i<K;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph[a][b] = 1;
            }

            int answer = 0;
            for(int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if(graph[i][j]==1 && !visited[i][j]){
                        dfs(i,j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            T--;
        }
    }
    public static void dfs(int i, int j){
        visited[i][j] = true;

        for(int k=0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if (x>=0 && y>=0 && x<N && y<M){
                if(graph[x][y]==1 && !visited[x][y]){
                    dfs(x,y);
                }
            }
        }
    }
}
