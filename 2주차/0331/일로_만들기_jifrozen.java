package 다이나믹프로그래밍;

import java.util.Scanner;

public class 일로_만들기_2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] d=new int[1000001];
		int X=sc.nextInt();

		for(int i=2;i<=X;i++){
			d[i]=d[i-1]+1;
			if(i%2==0){
				d[i]=Math.min(d[i],d[i/2]+1);
			}
			if(i%3==0){
				d[i]=Math.min(d[i],d[i/3]+1);
			}
		}

		System.out.println(d[X]);


	}
}
