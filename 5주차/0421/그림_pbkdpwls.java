import java.util.Scanner;

public class drawing {
    static int n,m;
    static int[][] arr;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static int max_value = 0;
    static int number = 0;
    static int temp = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로 크기
        m = sc.nextInt(); // 가로 크기

        arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    dfs(i,j);
                    max_value = Math.max(temp, max_value);
                    temp = 0;
                    number++;
                }
            }
        }
        System.out.println(number);
        System.out.println(max_value);

    }

    public static void dfs(int i, int j){
        arr[i][j] = 0;
        temp++;

        for(int k=0;k<4;k++){
            int tx = i+dx[k];
            int ty = j+dy[k];

            if(tx>=0 && ty>=0 && tx<n && ty<m){
                if(arr[tx][ty]==1){
                    dfs(tx,ty);
                }
            }
        }

    }
}
