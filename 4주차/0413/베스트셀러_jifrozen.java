
import java.util.HashMap;
import java.util.Scanner;

public class 베스트셀러 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> books = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = sc.next();
            books.put(book, books.getOrDefault(book, 0) + 1);
        }

        int result = 0;
        String answer = "";
        for (String key : books.keySet()) {
            if (books.get(key) > result) {
                answer = key;
                result = books.get(key);
            } else if (books.get(key) == result) {
                if (key.compareTo(answer) < 0) {
                    answer = key;
                    result = books.get(key);
                }
            }
        }

        System.out.println(answer);
    }
}
