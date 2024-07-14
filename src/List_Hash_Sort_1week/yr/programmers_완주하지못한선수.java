import java.util.*;

class Solution{
    public String solution(String[] participant, String[] completion){
        //✅ participant와 completion을 비내림차순으로 정렬한다.
        Arrays.sort(participant);
        Arrays.sort(completion);

        //✅ i를 0 ~ completion.length까지 순회한다.
        for ( int i = 0; i < completion.length; i++){
            //✅ participant와 completion이 다르면 반환한다.
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        // ✅ 마지막 인덱스까지 확인해도 정답이 나오지 않았다면 마지막 participant를 반환한다.
        // 반복문이 끝날 때까지 두 배열의 모든 요소가 같다면, participant 배열의 마지막 요소가 완주하지 못한 사람이 됩니다. 이는 완주하지 못한 사람이 completion 배열에 없기 때문입니다.
        return participant[participant.length - 1];
    }
}