import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 대문자 알파벳으로만 이루어져 있는 문자열
        // 이 문자열에 대해서 D-쌍
        // 이 문자열에 포함되어 있는
        // 거리가 D인 두 문자를 순서대로 나열한 것을 이 문자열의 D-쌍이라고 한다.
        // 예를 들어, 문자열 이 ZGBG라고 하자.
        // 이 문자열의 0쌍은 ZG GB BG가 되고

        // ZGBG

        int index = 0;
        while (true){
            String str = br.readLine();

            if (str.equals("*")){
                break;
            }

            boolean isRight = true;

            int len = str.length();

            index = len/2;

            while (index >=0) {
                isRight = true;
                HashMap<String, Integer> hmap = new HashMap<>();

                for (int i = 0; i + index + 1 < len; i++) {
                    String s = str.substring(i, i + 1);
                    s += str.substring(i + index + 1, i + index + 2);
                    hmap.put(s, hmap.getOrDefault(s, 0) + 1);
                }

                for (String key : hmap.keySet()){
                    if (hmap.get(key) > 1){
                        isRight = false;
                        break;
                    }
                }

                if (!isRight){
                    break;
                }

                index--;
            }

            if (isRight){
                bw.write(str+" is surprising.\n");
            }
            else{
                bw.write(str+" is NOT surprising.\n");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }

}
