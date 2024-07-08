import java.util.*;

class Solution{
    public int solution(int[] nums){
        int max = nums.length / 2; // 이건 ㄹㅇ 최대로 가져갈 수 있는 n/2개

        // 중복 제거하기
        HashSet<Integer> set = new HashSet<>();
        // 중복되는 값은 빼고 nums의 요소를 하나씩 살펴보면서 Set에 넣어줌
        for (int num: nums){
            set.add(num);
        }

        // 이렇게 중복 제거한 Set의 크기가 max보다 크면 max를, 작으면 numsSet의 size를 리턴
        if(set.size() > max){
			/*
				nums = {1,2,3,4,5,6}
				set.size = 6
				max = 6/3 = 3
			*/
            return max;
        }else{
            return set.size();
        }
    }
}