import java.util.*;

class Solution {
    //1. 전역 변수 선언: 정답 리스트
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        //2. result 초기화
        result = new ArrayList<>();

        //3. backtrack() 호출
        backtrack(new ArrayList<Integer>(), n, k, 1);
        return result;
    }

    private void backtrack(List<Integer> cur, int n, int k, int start) {
        //base case: cur.size() == k면 정답 리스트에 현재 조합 추가하고 종료
        if(cur.size() == k) {
            result.add(new ArrayList<>(cur)); return;
        }

        //recursive call: 배열 순회
        for(int i=start; i<=n; i++) {
            //현재 조합에 노드 숫자 추가 & 방문 처리
            cur.add(i);
            //backtrack(): 현재 i에 1을 더한 값을 backtrack에 start로 전달 (중복되지 않도록)
            backtrack(cur, n ,k, i+1);
            //현재 조합에서 노드 삭제
            cur.remove(Integer.valueOf(i));
        }
    }
}