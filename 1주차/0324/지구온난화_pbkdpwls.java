import java.io.IOException;
import java.util.*;


public class globalwarming {
    public static final int[] dx = {-1,1,0,0};
    public static final int[] dy = {0,0,-1,1};
    public static int R;
    public static int C;

    public static char [][] map;
    public static char [][] temp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        map = new char[R][C];
        temp = new char[R][C];
        sc.nextLine();

        for(int i = 0 ; i < map.length ; i++) {
            String s = sc.nextLine();
            map[i] = s.toCharArray();
            temp[i] = s.toCharArray();
        }

        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                if(map[i][j] == 'X') {

                    int count = 0;

                    for(int k = 0 ; k < dx.length ; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if((nx>=0 && nx < R && ny >=0 && ny < C )){
                            if(map[nx][ny] == 'X') {
                                continue;
                            }
                        }
                        count++;
                    }

                    if(count >= 3) {
                        temp[i][j] = '.';
                    }
                }
            }
        }

        // 출력할 범위
        int minx = -1;
        int miny = -1;
        int maxx = -1;
        int maxy = -1;

        int height = temp.length;
        int width = temp[0].length;

        for(int i=0; i<height; i++){

            boolean check = false;
            for(int j=0; j<width; j++){
                if(temp[i][j] == 'X'){
                    minx = i;
                    check=true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        for(int i=0; i<width; i++){
            boolean check = false;
            for(int j=0; j<height; j++){
                if(temp[j][i] == 'X'){
                    miny = i;
                    check=true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        for(int i=height-1; i>=0; i--){
            boolean check = false;
            for(int j=0; j<width; j++){
                if(temp[i][j] == 'X'){
                    maxx = i;
                    check=true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        for(int i=width-1; i>=0; i--){
            boolean check = false;
            for(int j=0; j<height; j++){
                if(temp[j][i] == 'X'){
                    maxy = i;
                    check=true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = minx;
        while(i <= maxx){
            int j = miny;
            while(j<=maxy){
                sb.append(temp[i][j]);
                j++;
            }
            sb.append("\n");
            i++;
        }

        System.out.println(sb);
    }
}
