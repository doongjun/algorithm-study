import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1654 - 랜선 자르기
 */
public class No1654 {
    static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        lines = new int[k];

        long max = Long.MIN_VALUE; // 랜선 중 최대길이 저장
        for (int i=0; i<k; i++) {
            int len = Integer.parseInt(br.readLine()); // 입력
            lines[i] = len;
            max = Math.max(max, len);
        }

        long answer = binarySearch(0, ++max, n);
        System.out.println(answer);
    }

    /**
     * 조건을 만족하는 랜선 길이의 최댓값을 이분탐색
     * @param min - 0
     * @param max - 갖고있는 랜선 길이의 최댓값
     * @param count - 갯수
     * @return 정답
     */
    private static long binarySearch(long min, long max, int count) {
        /**
         *  - Upper Bound : 특정 값보다 큰 값이 처음으로 나오는 위치
         *  - Lower Bound : 특정 값보다 크거나 같은 값이 처음 나오는 위치
         *
         *  이 문제의 경우, n개의 랜선을 만들 수 있는 중복 정답중에서 최대 길이를 찾아야한다.
         */
        long mid; // 중간 길이
        while (min < max) {
            mid = (min+max)/2;
            long result = 0;
            for (int len: lines) {
                result += len/mid;
            }

            if (result < count) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return max-1;
    }
}