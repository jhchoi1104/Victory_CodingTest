import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }

        if (set.size() >= (nums.length)/2) {
            return (nums.length)/2;
        }
        
        return set.size();
    }
}

// 배운 내용1: HashSet에서 사용할 수 있는 데이터타입은 Integer, String와 같이 참조형. 따라서 int은 사용불가
// 배운 내용2: 배열의 길이는 nums.length, 해시셋의 길이는 set.size()
// 시간복잡도: O(N)