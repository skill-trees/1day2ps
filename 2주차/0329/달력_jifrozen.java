package 2주차.0329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 달력 {
	public static class Time implements Comparable<Time>{
		int startTime;
		int endTime;
		public Time(int startTime,int endTime){
			this.startTime=startTime;
			this.endTime=endTime;
		}

		@Override
		public int compareTo(Time o) {
			if(this.startTime==o.startTime){
				return o.endTime-this.endTime;
			}
			return this.startTime-o.startTime;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		List<Time> times=new ArrayList<>();

		for(int i=0;i<N;i++){
			int S=sc.nextInt();
			int E=sc.nextInt();
			times.add(new Time(S,E));
		}
		Collections.sort(times);

		int row=0;
		int rowResult=0;
		int colResult=times.get(times.size()-1).endTime;
		int[][] map=new int[N][367];
		for(int i=0;i<N;i++){
			int start=times.get(i).startTime;
			int end=times.get(i).endTime;

			for(int j=0;j<N;j++){
				if(map[j][start]==1){
					continue;
				}

				for(int k=start;k<=end;k++){
					map[j][k]=1;
				}
				break;
			}
		}

		int widthLeft=365;
		int widthRight=0;
		int height=0;
		int result=0;

		for(int j=1;j<map[0].length;j++){
			boolean isCheck=true;
			for(int i=0;i<N;i++){
				if(map[i][j]==1){
					widthLeft=Math.min(widthLeft,j);
					widthRight=Math.max(widthRight,j);
					height=Math.max(height,i+1);
					isCheck=false;
				}
			}
			if(isCheck){
				result+=(widthRight-widthLeft+1)*height;
				widthLeft=365;
				widthRight=0;
				height=0;
			}
		}
		System.out.println(result);
	}
}
