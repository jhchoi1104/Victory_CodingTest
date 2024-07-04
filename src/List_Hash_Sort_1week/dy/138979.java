/* 연속된 부분 수열의 합 */
class 138979 {
    public int[] solution(int[] sequence, int k) {
        int end = 0;
        int sum = 0;
        int len = -1;

        int[] res = new int[2];

        for(int start = 0; start<sequence.length; start++) {
            while (end<sequence.length && sum < k) {
                sum += sequence[end++];
            }

            if (sum == k) {
                if(len == -1 || end - start < len) {
                    res[0] = start;
                    res[1] = end - 1;
                    len = end - start;
                }
            }

            sum -= sequence[start];
        }

        return res;
    }
}