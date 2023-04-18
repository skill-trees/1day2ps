import java.util.Scanner;

public class blackjack {
    static int[] visited;
    static int[] arr;
    static int answer = 0;
    static int[] result = new int[3];
    static int N,M;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new int[N];
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int depth){
        if(depth==3){
            int sum = 0;
            for(int s : result){
                sum+=s;
            }
            if(sum<=M){
                answer = Math.max(answer, sum);
            }
        }
        else {
            for(int i=depth;i<N;i++){
                if(visited[i]==0){
                    visited[i] = 1;
                    result[depth] = arr[i];
                    dfs(depth+1);
                    visited[i] = 0;
                }
            }
        }
    }
}
