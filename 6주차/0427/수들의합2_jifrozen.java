package 6주차.0427;

import java.util.Scanner;

public class 수들의합2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int start=0;
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] num=new int[N];
		for(int i=0;i<N;i++){
			num[i]=sc.nextInt();
		}
		int answer=0;
		for(int i=0;i<N;i++){
			int sum=0;
			for(int j=start;j<N;j++){
				sum+=num[j];
				if(sum==M){
					answer++;
					break;
				}
			}
			start+=1;
		}

		System.out.println(answer);
	}
}
