import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(DFS(1, 1));
	}

	public static long DFS(int x, int y) {
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		if (x == N && y == N) {
			return 1;
		}

		dp[x][y] = 0;

		int dx = x + map[x][y];
		int dy = y + map[x][y];

		// 아래와 오른쪽 이동 불가
		if (dx > N && dy > N) {
			return 0;
		}

		// 아래로 가는 경우
		if (dx <= N) {
			dp[x][y] = Math.max(dp[x][y], dp[x][y] + DFS(x + map[x][y], y));
		}

		// 오른쪽으로 가는 경우
		if (dy <= N) {
			dp[x][y] = Math.max(dp[x][y], dp[x][y] + DFS(x, y + map[x][y]));
		}

		return dp[x][y];
	}

}