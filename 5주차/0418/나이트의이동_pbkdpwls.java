import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class knight {
    static int dx[] = {-2,-1,-2,-1,1,2,2,1};
    static int dy[] = {-1,-2,1,2,-2,-1,1,2};
    static int visited[][];
    static int I,x1,y1,x2,y2,answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            I = sc.nextInt();
            visited = new int[I][I];
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            bfs(new Point(x1,y1,0));
            System.out.println(answer);
        }
    }

    public static void bfs(Point p){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        visited[p.x][p.y] = 1;

        while (!queue.isEmpty()){
            Point temp = queue.poll();

            if(temp.x==x2 && temp.y==y2){
                answer = temp.count;
                break;
            }

            for(int i=0;i<8;i++){
                int nx = temp.x+dx[i];
                int ny = temp.y+dy[i];
                int count = temp.count + 1;
                if (nx >= 0 && nx < I && ny < I && ny >= 0 && visited[nx][ny]==0) {
                    queue.offer(new Point(nx, ny, count));
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    static class Point{
        int x,y,count;

        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

