import java.util.Scanner;

public class oneline {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer[] = new int[N]; // 정답 배열

        // 2 1 1 0
        for(int i=0;i<N;i++){
            int left = scanner.nextInt(); // 왼쪽에 있는 큰 사람 수

            for(int j=0;j<N;j++){
                // 큰사람이 들어갈 자리를 비운 상태 + 들어가려는 자리 비어있을 떄
                if(left==0 && answer[j]==0){
                    answer[j] = i+1;
                    break;
                }
                // 큰사람이 들어갈 자리 덜비움 + 들어가려는 자리 비었을 때 (키 큰 사람 있는 경우 빈자리 지나침)
                else if(answer[j]==0){
                    left--;
                }
            }

        }

        // 결과 출력
        for(int i=0;i<N;i++) {
            System.out.print(answer[i]+" ");
        }
    }
}
