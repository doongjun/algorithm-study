/*
* 가장 긴 증가하는 부분 수열
* https://www.acmicpc.net/problem/11053
* Wrong 1/ 수열A에서 증가하는 부분의 개수를 count하고 그 값을 기준점으로 갱신
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11053 {
    static int n;
    static int [] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열의 크기 n (1 ~ 1,000)
        n = Integer.parseInt(st.nextToken());

        // 수열입력
        st = new StringTokenizer(br.readLine());
        A = new int[n];
        for(int i=0;i<n;i++){
            // (1 ~ 1,000)
            A[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dP());
    }
    static int dP(){
        int []dp = new int[n]; // 부분수열의 길이를 저장
        dp[0] = 1; // A[0]가 길이 1의 수열
        int increase = 1; // 증가수열의 길이

        for(int i=1;i<n;i++){
            dp[i] = 1;
            /* 처음 원소부터 i번의 앞까지 비교 */
            for(int j=0;j<i;j++){
                // j번째 원소가 현재의 원소보다 작으면서, 현재부분수열의 길이가 j번째 길이+1보다 작은경우
                if(A[j] < A[i] && dp[i] < dp[j]+1 ){
                    dp[i] = dp[j]+1; // 길이갱신
                }
            }
            increase = Math.max(increase,dp[i]);
        }
        return increase;
    }
}
