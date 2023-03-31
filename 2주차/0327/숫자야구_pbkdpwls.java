import java.util.*;

import static java.lang.System.exit;

public class baseball {
    private static boolean[] arr = new boolean[988]; // 가능성 답 배열
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 질문 수
        int answer = 0; // 가능성이 있는 답 개수

        for(int i=123;i<988;i++){
            arr[i] = true;
        }
        // 질문 입력
        for (int i=0;i<N;i++) {
            int temp = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            check(temp, a, b); // 가능성 포함, 제외 처리
        }
        // 123~987까지 가능성 카운트
        for(int i=123;i<988;i++){
            if(arr[i]){
                answer++;
            }
        }

        System.out.println(answer);

    }
    public static void check(int temp, int a, int b){
        int n1 = temp/100; // 첫번째 자리
        int n2 = temp%100/10; // 두번째 자리
        int n3 = temp%100%10; // 세번째 자리
        for (int i=123;i<988;i++) { // 123~987 숫자 가능성 전부 확인
            int strike = 0; // 스트라이크 수
            int ball = 0; // 볼 수

            if (!arr[i]){ // 가능성 없다고 이미 처리된 경우
                continue;
            }
            if (!validation(String.valueOf(i))) {
                arr[i] = false;
                continue;
            }
            int m1 = i/100; // 첫번째 자리
            int m2 = i%100/10; // 두번째 자리
            int m3 = i%100%10; // 세번째 자리

            // 스트라이크 확인
            if(n1==m1){ // 명령어 첫째자리 = 현재 검사중인 수 첫째자리
                strike++;
            }
            if(n2==m2){ // 명령어 둘째자리 = 현재 검사중인 수 둘째자리
                strike++;
            }
            if(n3==m3){ // 명령어 셋째자리 = 현재 검사중인 수 셋째자리
                strike++;
            }

            // 볼 확인
            if(n1==m2||n1==m3){
                ball++;
            }
            if(n2==m1||n2==m3){
                ball++;
            }
            if(n3==m1||n3==m2){
                ball++;
            }

            // 정답인 수라면 질문으로 들어온 수와 비교했을 때, 스트라이크 - 볼 수가 같아야함
            if(a!=strike || b!=ball){
                arr[i] = false;
            }
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
