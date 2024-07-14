import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();

        // s.charAt(i) => 해당 인덱스에 뭐가 있는지 알려줌

        // for 반복문을 돌려서 문자 하나하나에 접근한다
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            // 열린 괄호면~
            // 스택에 넣어준다
            if(c == '('){
                stack.push(c);
            }else{
                // 닫힌 괄호면~
                // 스택 팝()
                // 근데 스택이 비워진 상태에서 )가 들어오면 pop 할게 없음 -> 분기 처리 필요
                // stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        // 스택.isEmpty()
        answer =  stack.isEmpty();

        return answer;
    }
}