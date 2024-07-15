import java.util.*;

class Solution{
    public int[] solution(int[] prices){
        // answer 배열: 해당 시점에서 가격이 떨어지지 않은 기간 기록용
        int[] answer = new int[prices.length];
        /*
        이 코드에서 stack에 기록되는 것들은 주식 가격 배열 prices의 각 인덱스입니다.
        코드의 각 단계에서 스택에는 아직 주식 가격이 떨어지지 않은 시점의 인덱스가 저장됩니다.
        */
        Deque<Integer> stack =  new ArrayDeque<>();

        // prices의 인덱스를 순회
        for(int i = 0; i < prices.length; i++){
            // 스택이 빌 때까지 반복
            while(!stack.isEmpty()){
                int j = stack.peek();
                // 스택의 맨 위 인덱스의 가격(가장 최근에 들어온 값)이 현재 가격보다 큰지 확인
                if(prices[j] > prices[i]){
                    // 인덱스간 값 차이를 저장하고, 스택 맨 위 인덱스를 제거
                    answer[j] = i - j;
                    stack.pop();
                }
                // 스택의 맨 위 인덱스의 가격이 현재 가격보다 작으면 빠져나옴
                else break;
            }
            stack.push(i);
        }
        // 스택에 남은 인덱스들에 대해 기간을 계산하여 저장
        while(!stack.isEmpty()){
            int i = stack.pop();
            answer[i] = prices.length - i - 1;
        }
        return answer;
    }
}