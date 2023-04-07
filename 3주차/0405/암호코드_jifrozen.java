package 3주차.0405;

import java.util.Scanner;

public class 암호코드 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.next();

		long[] dp=new long[input.length()+1];

		if(input.charAt(0)=='0') {
			System.out.println(0);
			return;
		}else{
			dp[0]=1;
			dp[1]=1;
			for(int i=2;i<=input.length();i++){
				char c=input.charAt(i-1);
				if(c=='0'){
					if(input.charAt(i-2)=='1'||input.charAt(i-2)=='2'){
						//1 20 3
						dp[i]=dp[i-2]%1000000;
					}else{
						System.out.println(0);
						return;
					}
				}else{
					int str=Integer.parseInt(input.substring(i-2,i));
					if(str>=10&&str<27){
						dp[i]=(dp[i-1]+dp[i-2])%1000000;
					}else{
						dp[i]=dp[i-1]%1000000;
					}
				}
			}
		}

		System.out.println(dp[input.length()]%1000000);


	}
}
