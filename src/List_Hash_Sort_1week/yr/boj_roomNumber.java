import java.util.*;

class Main{
    public static void main(String[] args){

        // 방번호 입력받기
        Scanner sc = new Scanner(System.in);
        int roomNum = sc.nextInt();

        // 각 번호의 필요 개수 저장할 배열 생성(0~9)
        int arr[] = new int[10];
        // countSet: 플라스틱 숫자 '세트' 필요 개수 최대값
        int countSet = 0;

        // 방번호 한 글자씩 끊어서 순회하기 위해 방번호를 문자열로 바꿔줌
        String roomNumToStr = roomNum + "";
            // 숫자로 변환해서 다른 방법으로 접근하는 방법도 있음
        // 한 글자씩 끊어서 번호 몇 번 나오는지 arr 배열에 적어주기
                           // 방번호 자리수(몇 글자인지)
        for(int i = 0; i < roomNumToStr.length(); i++){
            // 해당 번호(인덱스)의 값(개수) 1 증가 시키기
            arr[roomNum % 10]++;
            // 개수 처리한 숫자는 하나씩 지우고 다음 숫자 처리 준비(나머지 날려)
            roomNum /= 10;
        }

        // 6이랑 9 개수 처리
        // 1) 일단 6 필요 갯수랑 9 필요 개수 더함(6 필요 개수에 모으기)
        arr[6] += arr[9];
        // 2) 더했으니까 9에 저장된 필요 개수 0으로 초기화
        arr[9] = 0;

        // 필요한 세트 개수 구하기
        for(int i = 0; i < 10; i++){
            // countNum: 각 번호의 필요 개수 담을 변수
            int countNum = 0;

            // 숫자가 6,9일 경우 필요 개수
            // (9의 개수를 6에 합쳐놓은 상태이므로 6만 따짐)
            if(i == 6) {
                if (arr[i] % 2 == 0) {
                    // 짝수 개일 때
                    countNum = arr[i] / 2;
                } else {
                    // 홀수 개 일 때
                    countNum = (arr[i] / 2) + 1;
                }
            }else{
                // 숫자가 6,9아닌 수일 때 -> 해당 인덱스에 해당하는 값
                countNum = arr[i];
            }

            // 필요한 세트 개수 최대값 업데이트
            if(countNum >= countSet){
                countSet = countNum;
            }

        }
            // 필요한 최대 세트 개수 출력
            System.out.println(countSet);

    }
}