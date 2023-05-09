import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2110 - 공유기 설치
 */
public class No2110 {
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        houses = new int[n];

        for (int i=0; i<n; i++) {
            houses[i] = Integer.parseInt(br.readLine()); // 입력
        }
        Arrays.sort(houses);

        int answer = binarySearch(1, houses[n-1] - houses[0] + 1, c);
        System.out.println(answer);
    }

    /**
     * 조건을 만족하는 가장 인접한 두 공유기 사이의 최대 거리를 이분탐색
     * @param lo - (최소거리) 최솟값 : 1
     * @param hi - (최소거리) 최댓값 : houses[n-1] - houses[0] + 1
     * @param c - 공유기의 개수
     * @return 정답
     */
    private static int binarySearch(int lo, int hi, int c) {
        while(lo < hi) {
            int mid = (hi+lo)/2;
            if(count(mid) < c) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo-1;
    }

    /**
     * @param d - 거리
     * @return 설치 가능한 공유기의 개수
     */
    private static long count(int d) {
        // 첫 번째 집 설치
        int count = 1;
        int lastLocate = houses[0];

        for(int i = 1; i < houses.length; i++) {
            int locate = houses[i];
            // 현재 집의 위치와 직전 위치 집 사이의 거리를 비교
            if(locate - lastLocate >= d) {
                count++; // 설치 개수 ++
                lastLocate = locate; // 마지막 위치 갱신
            }
        }
        return count;
    }

}