package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 촌수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        int[] visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(a);
        visited[a] = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (num == b) {
                answer = visited[num];
                break;
            }
            for (int i = 0; i < arr.get(num).size(); i++) {
                if (visited[arr.get(num).get(i)] != 0) {
                    continue;
                }
                pq.offer(arr.get(num).get(i));
                visited[arr.get(num).get(i)] += visited[num] + 1;
            }
        }

        // for(int i=0;i<visited.length;i++){
        // System.out.println(visited[i]);
        // }
        System.out.println(answer);

    }
}
