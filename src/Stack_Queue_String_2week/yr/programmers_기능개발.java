import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds){
        // 배포한 작업 개수 저장하는 곳
        List<Integer> counts = new ArrayList<>();
        // 작업 종료까지 걸리는 시간 저장하는 곳
        Queue<Integer> queue = new ArrayDeque<>();

        // 작업 종료까지 걸리는 시간(일수) 계산하여 큐에 저장
        for(int i = 0; i < progresses.length; i++){
            /*
            올림처리 해줘야 함(Math.ceil)
            Math.ceil의 반환형은 double이므로 (int)로 형변환 해줘야 함
            */
            /* 오류 발생 원인
            올림 처리를 할 때 (100 - progresses[i]) / speeds[i] 전체를 Math.ceil로 감싸야 합니다.
            현재 코드에서는 Math.ceil(100 - progresses[i]) / speeds[i]로 되어 있어,
            Math.ceil 함수가 100 - progresses[i]만 감싸고 있습니다. 이로 인해 올바른 계산이 이루어지지 않습니다.
            queue.add((int)Math.ceil(100-progresses[i])/speeds[i]);
            */
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        // 배포 작업 수(count) 처리
        while(!queue.isEmpty()){
            // 큐에서 요소 하나 뽑기
            // (queue.remove() -> 큐 맨 앞에 있는 값 반환 후 삭제)
            int current = queue.remove();
            // 단위 별 배포 작업 개수(count) 카운팅 시작(1로 초기화)
            int count = 1;

            // 큐의 맨 위 요소가 자신(current)보다 작은 동안(큰 게 나타날 때까지) 요소를 하나씩 제거하고 작업 개수(count)를 1 늘리기
            while(!queue.isEmpty() && queue.peek() <= current){
                queue.remove();
                count++;
            }

            // 작업 개수(count)를 작업 개수 내역(counts) 리스트에 저장하기
            counts.add(count);
        }

        // 작업 개수(counts) 리턴하기
        // counts 리스트에 있던 요소들을 인덱스 하나씩 차곡차곡 answer 배열에 넣기
        int[] answer = new int[counts.size()];
        for(int i = 0; i < counts.size(); i++){
            answer[i] = counts.get(i);
        }
        return answer;
    }
}