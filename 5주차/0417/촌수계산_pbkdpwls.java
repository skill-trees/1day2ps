import java.util.*;

public class degree {
    static int n;
    static int visited[] = new int[102];
    static int arr[][] = new int[102][102];
    static int a,b,m;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        for(int i=0;i<m;i++){
            int x,y;
            x = sc.nextInt();
            y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        bfs(a,b);

        if(visited[b]==0){
            System.out.println(-1);
        }
        else{
            System.out.println(visited[b]);
        }

    }
    public static void bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int v = queue.poll();
            if(v==end){
                break;
            }
            for(int i=1;i<=n;i++){
                if(arr[v][i]==1 && visited[i]==0){
                    visited[i] = visited[v]+1;
                    queue.add(i);
                }
            }
        }
    }
}
