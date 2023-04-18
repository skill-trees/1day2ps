import java.util.*;

public class tsp2 {
    private static int[][] W;
    private static int min_value = Integer.MAX_VALUE;
    static int N;
    private static int[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                W[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            visited = new int[N];
            visited[i] = 1;
            dfs(1,i,i,0);
        }
        System.out.println(min_value);
    }
    private static void dfs(int depth, int s, int n, int temp){ // s = 시작위치, n = 현재위치, temp = 합계
        if(temp > min_value){ // 현재 합계가 최솟값보다 작으면 패스
            return;
        }
        // 전부 순회했을 때
        if(depth==N && W[n][s]!=0){
            temp += W[n][s];
            min_value = Math.min(temp, min_value);
            return;
        }

        // 현재위치에서 갈 수 있는 곳 모두 방문
        for(int i=0;i<N;i++){
            if(visited[i]==0 && W[n][i]!=0){
                visited[i] = 1;
                dfs(depth+1, s, i, temp + W[n][i]);
                visited[i] = 0;
            }
        }

    }
}
