
import java.util.Scanner;

public class 블랙잭 {
    static int M;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        int[] visited = new int[N];
        DFS(num, visited, 0, 0);

        System.out.println(answer);

    }

    public static void DFS(int[] num, int[] visited, int cnt, int sum) {
        if (cnt == 3) {
            if (M >= sum) {
                answer = Math.max(answer, sum);
                return;
            }
        } else {
            for (int i = 0; i < num.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    DFS(num, visited, cnt + 1, sum + num[i]);
                    visited[i] = 0;
                }
            }
        }
    }
}
