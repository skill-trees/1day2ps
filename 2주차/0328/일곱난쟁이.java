package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 일곱난쟁이 {
	static int[] nanjang;
	static int[] visited=new int[9];
	static int[] answer=new int[7];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		nanjang=new int[9];
		for(int i=0;i<9;i++){
			nanjang[i]=sc.nextInt();
		}

		DFS(0,0);
		Arrays.sort(answer);

		for(int i=0;i<7;i++){
			System.out.println(answer[i]);
		}


	}
	public static void DFS(int cnt,int sum){
		if(cnt==7){
			if(sum==100){
				int index=0;
				for(int i=0;i<9;i++){
					if(visited[i]==1){
						answer[index++]=nanjang[i];
					}
				}
			}
			return;
		}
		for(int i=0;i<9;i++){
			if(visited[i]==0) {
				visited[i] = 1;
				DFS(cnt+1, sum + nanjang[i]);
				visited[i] = 0;
			}
		}
	}


}
