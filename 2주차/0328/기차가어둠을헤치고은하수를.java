package 구현;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 기차가어둠을헤치고은하수를 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();

		int[][] train=new int[N][20];

		while(M-->0){
			int order=sc.nextInt();
			if(order==1){
				int i=sc.nextInt();
				int x=sc.nextInt();
				train[i-1][x-1]=1;
			}else if(order==2){
				int i=sc.nextInt();
				int x=sc.nextInt();
				train[i-1][x-1]=0;
			}else if(order==3){
				int i=sc.nextInt();
				for(int j=19;j>0;j--){
					train[i-1][j]=train[i-1][j-1];
				}
				train[i-1][0]=0;
			}else if(order==4){
				int i=sc.nextInt();
				for(int j=0;j<19;j++){
					train[i-1][j]=train[i-1][j+1];
				}
				train[i-1][19]=0;

			}
		}
		HashSet<String> set=new HashSet<>();

		for(int i=0;i<N;i++){
			set.add(Arrays.toString(train[i]));
		}

		System.out.println(set.size());
	}
}
