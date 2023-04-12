
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int[] dp = new int[M + 1];
        dp[S] = 1;

        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < M + 1; j++) {
                if (dp[j] == i) {
                    if (j - num >= 0 && j - num <= M) {
                        list.add(j - num);
                    }
                    if (j + num >= 0 && j + num <= M) {
                        list.add(j + num);
                    }
                }
            }
            for (int k : list) {
                dp[k] = i + 1;
            }
        }

        for (int j = M; j >= 0; j--) {
            if (dp[j] == N + 1) {
                System.out.println(j);
                return;
            }
        }

        System.out.println(-1);
    }
}
