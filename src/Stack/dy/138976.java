import java.util.Arrays;

/* 완주하지 못한 선수 */
class 138976 {
    public String solution(String[] participant, String[] completion) {
        //1. 각 목록을 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        //2. 각 목록 원소 인덱스가 일치하지 않는 이름을 리턴: 완주하지 못했을 참여자
        for(int i=0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) return participant[i];
        }

        //3. 완주자 목록의 인덱스를 끝까지 돌았는데도 발견하지 못할 경우, 마지막 참여자가 미완주자
        return participant[participant.length-1];
    }
}