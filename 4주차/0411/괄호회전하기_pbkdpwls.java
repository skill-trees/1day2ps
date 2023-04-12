import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++){
            if(check(s)==1){
                answer++;
            }
            s = s.substring(1,s.length())+s.substring(0,1);
        }

        return answer;
    }
    public int check(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.size()==0){
                stack.push(c);
            }
            else{
                if(c==']' && stack.peek() =='['){
                    stack.pop();
                }
                else if(c=='}'&& stack.peek() =='{'){
                    stack.pop();
                }
                else if(c==')'&& stack.peek() =='('){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
        }
        if(stack.size()==0){
            return 1;
        }
        return 0;
    }
}