package 6주차.0427;

import java.util.HashMap;
import java.util.Scanner;

public class 회전초밥 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int d=sc.nextInt();
		int k=sc.nextInt();
		int c=sc.nextInt();

		int start=0,end=k;
		int[] sushi=new int[N];
		for(int i=0;i<N;i++){
			sushi[i]=sc.nextInt();
		}
		int result=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(c,1);
		for(int i=start;i<end;i++){
			map.put(sushi[i%N],map.getOrDefault(sushi[i%N],0)+1);
		}

		for(int i=0;i<N;i++){
			result=Math.max(result,map.size());
			if(map.get(sushi[i%N])-1==0){
				map.remove(sushi[i%N]);
			}else {
				map.put(sushi[i % N], map.get(sushi[i % N])-1);
			}
			start+=1;
			map.put(sushi[end%N],map.getOrDefault(sushi[end%N],0)+1);
			end+=1;
		}
		System.out.println(result);
	}

}
