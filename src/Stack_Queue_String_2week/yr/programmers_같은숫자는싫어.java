import java.util.*;

public class Solution{
    // 1. Stack 사용
    public int[] solution1(int[] arr){
        // 1) 스택 생성
        Deque<Integer> stack = new ArrayDeque<>();

        // 2) arr 배열 순회
        for (int i = 0; i < arr.length; i++) {
            // 각 원소
            int num = arr[i];

            // stack이 비어있거나 num이 직전에 담긴 값과 다를 경우 stack에 num을 넣기
            if (stack.isEmpty() || !stack.peek().equals(num)) {
                stack.push(num);
            }
        }

        // 3) stack에 있는 원소들을 answer 배열에 담아주기(들어갔던 순서대로!)
        int[] answer = new int[stack.size()];
        /*
        배열의 인덱스 초기화 -> stack의 원소들을 배열에 순서대로 넣기 위해 인덱스 사용
        이 때 stack에서 pop한 요소를 answer 배열의 '뒤쪽'부터 채우도록 인덱스 조작해서 초기화 해주기
        */
        int index = stack.size()-1;
        // stack 순회하며 num들을 answer 배열에 넣어줘야 함
        /*
        그런데 일반 for문을 이용해 순회하려고 하는 경우
        근데 Deque의 요소들은 인덱스 기반으로 접근할 수 없어서
        순차적으로 요소를 처리하려면 Iterator가 필요함
        -> 그래서 Iterator 쓰거나 향상된 for문 써야 함
        */
        /*for (int num : stack) {
            answer[index++] = num;
        }*/
        // stack이 비어있지 않으면 stack에서 pop한 요소를 현재 index 값에 넣기
        // 그 후 index값 1 감소시키기
        while(!stack.isEmpty()){
            answer[index--] = stack.pop();
        }
        return answer;
    }

    // 2. ArrayList 사용
    public int[] solution2(int arr[]){
        // ArrayList 생성
        ArrayList<Integer> list = new ArrayList<>();
        // 비교를 위해 arr[0]을 미리 list에 넣어놓기
        list.add(arr[0]);

        // arr 순회하며 list에 해당 num이 없으면 추가, 있으면 무시
        // arr[0]은 미리 담아놨으므로 인덱스1부터 시작
        for(int i = 1; i < arr.length; i++){
            // 있을 때
            if(arr[i-1] == arr[i]){
                continue;
            }else{
                // 없을 때
                list.add(arr[i]);
            }
        }
        // ArrayList를 배열로 바꾸기
        return list.stream().mapToInt(i -> i).toArray();
        /*
         * a. stream() : list를 stream으로 변환
         * b. mapToInt(i -> i) : 스트림의 각 요소를 int로 변환
         * c. toArray() : IntStream의 요소들을 int배열로 변환
         * */

    }
}