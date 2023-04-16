class Solution {
    public int solution(String s) {
        int result = s.length();
        String compression = "";
        String answer = "";
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            compression = s.substring(0, i);
            int n = i;
            int cnt = 1;
            for (int j = i; j < s.length(); j = j + i) {
                String sub = "";
                for (int k = j; k < j + i; k++) {
                    if (k < s.length()) {
                        sub += s.charAt(k);
                    }
                }
                if (compression.equals(sub)) {
                    cnt += 1;
                } else {
                    if (cnt < 2) {
                        answer += compression;
                    } else {
                        answer += cnt + compression;
                    }
                    compression = sub;
                    cnt = 1;
                }
            }
            if (cnt < 2) {
                answer += compression;
            } else {
                answer += cnt + compression;
            }
            result = Math.min(result, answer.length());
            answer = "";
        }
        return result;
    }

}