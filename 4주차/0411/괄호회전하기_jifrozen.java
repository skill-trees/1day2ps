import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str = s.substring(i, s.length()) + s.substring(0, i);
            if (isCheckAlright(str)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isCheckAlright(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char stackPop = stack.pop();
                if (c == '}') {
                    if (stackPop != '{') {
                        return false;
                    }
                }
                if (c == ')') {
                    if (stackPop != '(') {
                        return false;
                    }
                }
                if (c == ']') {
                    if (stackPop != '[') {
                        return false;
                    }
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }
}