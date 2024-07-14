// 1. HashSet 쓰지 않는 방법 - 배열, distinct() 활용
import java.util.*;

class Solution{
	public int solution(int[] nums){
		// 1. 
		int answer = nums.length / 2; // 미리 최대인 경우 초기화
		
		// nums에서 중복 제거하여 새로운 배열에 담기(stream 활용)
		int[] distArr = Arrays.stream(nums).distinct().toArray();
		/*
			toArray() 메서드는 스트림의 요소들을 배열로 변환하는 역할을 합니다.
			Arrays.stream(nums).distinct()는 nums 배열에서 중복된 요소들을 제거하고, 그 결과를 스트림으로 반환합니다.
			그 다음에 toArray()를 사용하여 이 스트림을 다시 배열로 변환합니다.
		*/
		
		// 2. 
		if(distArr.length < nums.length/2){
			answer = distArr.length;

		}
		return answer;	
	}
}


// 2. HashSet 쓰는 방법
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