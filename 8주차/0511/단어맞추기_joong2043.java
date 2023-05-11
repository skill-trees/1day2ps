import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String str = br.readLine();

            char[] charArr = new char[str.length()];

            for (int j = 0; j < str.length(); j++){
                charArr[j] = str.charAt(j);
            }

            // 주어진 단어가 마지막 단어라면 그냥 주어진 단어 출력

            // [E, H, L, L, O]

            // D R I N K

            // D R K N I

            int index = -1;
            int index2 = 0;
            char temp;

            for (int j = str.length() -1; j >0 ; j--){
                if (charArr[j-1] < charArr[j]){
                    index = j-1;
                    break;
                }
            }

            if (index != -1){
                for (int j = charArr.length-1; j >= 0; j--){
                    if (charArr[index] < charArr[j]){
                        index2 = j;
                        break;
                    }
                }

                temp = charArr[index];
                charArr[index] = charArr[index2];
                charArr[index2] = temp;

                Arrays.sort(charArr, index + 1, charArr.length);
            }

            for (int j =0; j < str.length(); j++){
                sb.append(charArr[j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}