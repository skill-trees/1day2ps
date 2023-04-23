
import java.util.*;

public class 케빈_베이컨의_6단계_법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int INF = (int) 1e9;

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        int a = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        int result = INF;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += arr[i][j];
            }
            if (result > sum) {
                result = sum;
                answer = i;
            }
        }

        System.out.print(answer);

    }
}
