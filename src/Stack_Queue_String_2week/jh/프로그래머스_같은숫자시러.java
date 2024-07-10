import java.util.*;
import java.util.stream.*;

public class Solution {
    public Integer[] solution(int []arr) {
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<arr.length;i++) {
            if (!stack.isEmpty()&&stack.peek()==arr[i]) {
                continue;
            } else {
                stack.push(arr[i]);
            }
        }
        
        List<Integer> list = stack.stream().collect(Collectors.toList());
        Collections.reverse(list);

        return list.toArray(new Integer[0]);
    }
}