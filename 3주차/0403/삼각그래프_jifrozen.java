package 3주차.0403;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각그래프 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int index=0;
		while(true){
			int N=Integer.parseInt(br.readLine());
			int[][] map=new int[N][3];

			index+=1;
			if(N==0) break;

			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<3;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}


			for(int i=1;i<N;i++){
				if(i==1){
					map[i][0]+=map[i-1][1];
					map[i][1]+=Math.min(Math.min(map[i-1][1],map[i-1][1]+map[i-1][2]),map[i][0]);
					map[i][2]+=Math.min(Math.min(map[i-1][1],map[i-1][1]+map[i-1][2]),map[i][1]);
					continue;
				}
				map[i][0]+=Math.min(map[i-1][0],map[i-1][1]);
				map[i][1]+=Math.min(Math.min(Math.min(map[i-1][1],map[i-1][2]),map[i-1][0]),map[i][0]);
				map[i][2]+=Math.min(Math.min(map[i-1][2],map[i-1][1]),map[i][1]);

			}

			System.out.println(index+". "+map[N-1][1]);


		}
	}
}
