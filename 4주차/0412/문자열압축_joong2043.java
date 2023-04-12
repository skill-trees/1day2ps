import java.util.*;
class Solution {
    static int minNum = Integer.MAX_VALUE;

    public int solution(String s) {

        int answer = -1;

        if(s.length() == 1){
            return 1;
        }

        for(int i = 1; i < s.length(); i++){

            Stack<String> stack = new Stack<>();

            StringBuilder sb = new StringBuilder();

            boolean again = true;

            String str = "";

            int j = 0;
            int count = 1;

            while(again){
                // 0,1 1,2 2,3 3,4
                // 0,2 2,4 4,6 6,8
                if(i+j < s.length()){
                    str = s.substring(j, i+j);
                }
                else{
                    str = s.substring(j,s.length());
                    again = false;
                }

                j=i+j;

                if(stack.isEmpty()){
                    stack.push(str);
                    continue;
                }

                if(stack.peek().equals(str)){
                    // 마지막 문자가 아닐 경우
                    count++;

                    // 마지막 문자일 경우
                    if(!again){
                        sb.append(count);
                        sb.append(stack.pop());
                    }
                }
                else{
                    String popedStr = stack.pop();
                    if(count > 1){
                        sb.append(count);
                    }
                    sb.append(popedStr);

                    // 마지막 문자가 아닐 경우
                    if(again){
                        stack.push(str);
                        count = 1;
                    }
                    // 마지막 문자일 경우 스택에 추가할 필요 없이 바로 StringBuilder에 넣어주면 된다.
                    else{
                        sb.append(str);
                    }
                }

            }

            // System.out.println(sb);
            minNum = Math.min(minNum, sb.length());
        }

        answer = minNum;
        return answer;
    }

}