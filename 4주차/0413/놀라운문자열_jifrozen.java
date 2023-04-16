
import java.util.HashMap;
import java.util.Scanner;

public class 놀라운_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            if (str.equals("*"))
                break;
            int len = str.length();
            boolean isSurprising = true;
            for (int i = 1; i <= len - 1; i++) {
                HashMap<String, Integer> map = new HashMap<>();
                for (int j = 0; j <= len - 2 - i + 1; j++) {
                    String combStr = String.valueOf(str.charAt(j)) + String.valueOf(str.charAt(j + i));
                    map.put(combStr, map.getOrDefault(combStr, 0) + 1);
                }
                for (String key : map.keySet()) {
                    if (map.get(key) > 1) {
                        isSurprising = false;
                        break;
                    }
                }
                if (!isSurprising) {
                    break;
                }
            }
            if (isSurprising) {
                System.out.println(str + " is surprising.");
            } else {
                System.out.println(str + " is NOT surprising.");
            }
        }
    }
}
