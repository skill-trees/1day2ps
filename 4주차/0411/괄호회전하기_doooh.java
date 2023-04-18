import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // 주어진 문자열 회전
            String temp = s.substring(i) + s.substring(0, i);
            Stack<Character> brakets = new Stack<>();
            
            for(int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                
                // stack 에 문자 전부 넣기
                if(brakets.isEmpty()) {
                    brakets.push(ch);
                } else {
                    
                    // 연속적인 경우에만 pop 수행
                    if(brakets.peek() == '[' && ch == ']') {
                        brakets.pop();
                    } else if(brakets.peek() == '(' && ch == ')') {
                        brakets.pop();
                    } else if(brakets.peek() == '{' && ch == '}') {
                        brakets.pop();
                    } else {
                        brakets.push(ch);
                    }
                }
       
            }
            
            if(brakets.size() == 0) answer++;
    
        }
        
        return answer;
    }
}