package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 한줄로서기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<Integer> arr=new ArrayList<>();
		int[] result=new int[N];
		for(int i=0;i<N;i++){
			arr.add(sc.nextInt());
		}


		for(int i=0;i<N;i++){
			int left=arr.get(i);
			for(int j=0;j<N;j++) {
				if (left == 0 && result[j] == 0) {
					result[j] = i + 1;
					break;
				} else if (result[j] == 0) {
					left--;
				}
			}
		}

		for(int i=0;i<N;i++){
			System.out.print(result[i]+" ");
		}








	}
}
