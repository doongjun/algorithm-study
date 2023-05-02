/*나무자르기
 * https://www.acmicpc.net/problem/2805
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 나무의 수 N
        int N = Integer.parseInt(st.nextToken());
        // 나무의 길이 M
        int M = Integer.parseInt(st.nextToken());

        long start = 0, end = 0;
        long []len_info = new long[N]; // 길이정보를 담을 배열
        st = new StringTokenizer(br.readLine());
        // 나무의 수 만큼 길이정보를 저장하고, 최대 길이를 저장
        for(int i=0;i<N;i++){
            len_info[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end,len_info[i]);
        }

        long total = 0,mid;
        long maxLen = 0;

        while(start <= end){ // 시작지점과 끝지점이 엇갈릴 때까지
            total = 0;
            mid = (start + end) / 2; // 중간지점
            for(int i=0;i<N;i++){
                if(len_info[i]-mid > 0) // 길이를 중간지점으로 뺀 값이 양수이면
                    total = total+ (len_info[i] - mid); // 남은부분 저장
            }
            // 남은부분과 원하는 길이 비교
            if(total >= M){ // 원하는 길이보다 많이 남은경우
                maxLen = mid; // 최대높이를 저장하고
                start = mid+1; // 시작지점을 중간지점 + 1 로 설정
            }
            else // total < M
                end = mid-1; // 끝지점을 중간지점 - 1 로 설정
        }
        System.out.println(maxLen);
    }
}