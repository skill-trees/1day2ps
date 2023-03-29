
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 숫자야구 {
	public static List<Node> nodes=new ArrayList<>();
	public static class Node{
		String data;
		int strike;
		int ball;
		public Node(String data,int strike,int ball){
			this.data=data;
			this.strike=strike;
			this.ball=ball;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int result=0;
		for(int i=0;i<N;i++){
			int num=sc.nextInt();
			int strike=sc.nextInt();
			int ball=sc.nextInt();
			nodes.add(new Node(String.valueOf(num),strike,ball));
		}
		for (int i = 123; i < 999; i++) {
			int allTestCnt=0;
			if (!validation(String.valueOf(i))) {
				continue;
			}
			for(int j=0;j<nodes.size();j++){
				String data=nodes.get(j).data;
				int strike=nodes.get(j).strike;
				int ball=nodes.get(j).ball;

				if(baseBallGameStart(data,String.valueOf(i),strike,ball)){
					allTestCnt+=1;
				}else{
					continue;
				}

			}

			if(allTestCnt==N){
				result+=1;
			}
		}
		System.out.println(result);

	}

	public static boolean baseBallGameStart(String num,String comparisionNum,int strike,int ball){
		int s=0;
		int b=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(num.charAt(i)==comparisionNum.charAt(j)){//
					if(i==j){
						s++;
					}else{
						b++;
					}
				}
			}
		}
		if(strike==s&&ball==b){
			return true;
		}else{
			return false;
		}
	}
	public static boolean validation(String num){
		if(num.charAt(0)==num.charAt(1)){
			return false;
		}
		if(num.charAt(1)==num.charAt(2)){
			return false;
		}
		if(num.charAt(0)==num.charAt(2)){
			return false;
		}
		if(num.charAt(0)=='0'||num.charAt(2)=='0'||num.charAt(1)=='0'){
			return false;
		}
		return true;
	}

}
