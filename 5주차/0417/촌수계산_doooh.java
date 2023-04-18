import java.io.*;
import java.util.*;

public class Main {
    
    static int end, answer = -1;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); //부모 자식들 간의 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향
            graph.get(from).add(to);  // from -> to
            graph.get(to).add(from);  // to -> from
        }
       
        dfs(start, 0);
        System.out.println(answer);
    }

    private static void dfs(int point, int cnt) {
        visited[point] = true;
        for (int x : graph.get(point)) {
            if (!visited[x]) { 
                if (x == end) { //end에 도달하면
                    answer = cnt + 1;
                    return;
                }
                //다음 촌수로 이동
                dfs(x, cnt + 1);
            }
        }
    }
}