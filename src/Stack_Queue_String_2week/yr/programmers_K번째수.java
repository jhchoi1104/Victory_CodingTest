import java.util.Arrays;

class Solution{
    public int[] solution(int[] array, int[][] commands){
        // 정답 담아서 리턴할 배열
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
             /*
             '~번째'랑 '인덱스'랑 구분해서 범위를 잘 처리해줘야 함
             문제에서 말하는 건 '~번째', 내가 코드로 짜는 건 '인덱스'
             => k번째 = 인덱스 [k]-1
             */
            // copyOfRange(): 특정 범위 배열 복사
            int temp[] = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            // 복사한 배열 정렬하기
            Arrays.sort(temp);
            // k번째 수 구하기
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}