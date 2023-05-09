import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2805 - 나무 자르기
 */
public class No2805 {
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        trees = new int[n];

        int max = Integer.MIN_VALUE; // 랜선 중 최대길이 저장
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int len = Integer.parseInt(st.nextToken()); // 입력
            trees[i] = len;
            max = Math.max(max, len);
        }

        int answer = binarySearch(0, max, m);
        System.out.println(answer);
    }

    /**
     * 조건을 만족하는 절단기 높이의 최댓값을 이분탐색
     * @param min - 0
     * @param max - 나무 길이의 최댓값
     * @param goal - 필요한 나무 총 길이
     * @return 정답
     */
    private static int binarySearch(int min, int max, int goal) {
        while (min < max) {
            int mid = (min+max)/2;
            if (getSum(mid) < goal) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return min-1;
    }

    /**
     * 절단기 높이로 나무를 자른 뒤 높이의 합
     * @param h - 절단기 높이
     * @return 절단된 나무 길이의 합
     */
    private static long getSum(int h) {
        long sum = 0;
        for (int len: trees) {
            if (len > h) sum += (len-h);
        }
        return sum;
    }

}