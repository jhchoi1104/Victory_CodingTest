import java.util.*;

class Solution {
    //1. 전역 변수 선언: 정답 리스트
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        //2. 정답 리스트 초기화
        result = new ArrayList<>();

        //3. 조합 크기 순회: 공집합과 배열 전체를 포함
        for(int len=0; len <= nums.length; len++) {
            //4. backtrack()
            backtrack(new ArrayList<Integer>(), len, nums, 0);
        }

        return result;
    }

    private void backtrack(List<Integer> cur, int len, int[] nums, int start) {
        /* base case */
        if (cur.size() == len) {
            result.add(new ArrayList<>(cur)); return;
        }

        /* recursive call */
        //1. nums 배열 내부 순회: start부터
        for(int i=start; i<nums.length; i++) {
            cur.add(nums[i]); //2. 리스트에 노드값 추가
            backtrack(cur, len, nums, i+1); //3. backtrack()
            cur.remove(Integer.valueOf(nums[i])); //4. backtrack 완료 후: 리스트에서 현재 노드값 삭제
        }
    }
}