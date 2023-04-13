import java.util.*;

class Solution {
    static double[] discount = { 10, 20, 30, 40 };

    static class Response implements Comparable<Response> {
        int totalPrice;
        int isEmoticonPlus;

        Response(int totalPrice, int isEmoticonPlus) {
            this.totalPrice = totalPrice;
            this.isEmoticonPlus = isEmoticonPlus;
        }

        @Override
        public int compareTo(Response other) {
            if (this.isEmoticonPlus == other.isEmoticonPlus) {
                return other.totalPrice - this.totalPrice;
            }
            return other.isEmoticonPlus - this.isEmoticonPlus;

        }

    }

    static class User implements Comparable<User> {
        int id;
        int discount;
        int end;

        User(int id, int discount, int end) {
            this.id = id;
            this.discount = discount;
            this.end = end;
        }

        @Override
        public int compareTo(User other) {
            return this.discount - other.discount;

        }

        public String toString() {
            return discount + " " + end;
        }
    }

    static ArrayList<Response> responses = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        DFS(emoticons, users, new double[emoticons.length], 0);

        Collections.sort(responses);

        answer[0] = responses.get(0).isEmoticonPlus;
        answer[1] = responses.get(0).totalPrice;
        return answer;
    }

    public static void DFS(int[] emoticons, int[][] users, double[] discountInfo, int level) {
        if (level == emoticons.length) {
            int totalPr = 0;
            int totalEmoticonPlus = 0;
            for (int i = 0; i < users.length; i++) {
                int userPr = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] <= discountInfo[j]) {
                        userPr += emoticons[j] - emoticons[j] * (discountInfo[j] / 100);
                    }
                }
                if (userPr >= users[i][1]) {
                    totalEmoticonPlus += 1;
                } else {
                    totalPr += userPr;
                }
            }
            responses.add(new Response(totalPr, totalEmoticonPlus));
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                discountInfo[level] = discount[i];
                DFS(emoticons, users, discountInfo, level + 1);
            }
        }
    }
}
