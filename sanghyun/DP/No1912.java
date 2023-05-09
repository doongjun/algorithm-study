/*
* 연속합
* https://www.acmicpc.net/problem/1912
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1912 {
    static int n;
    static int [] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n개의 정수로 이루어진 수열의 크기 (1~100,000)
        n = Integer.parseInt(st.nextToken());

        // 수열입력
        st = new StringTokenizer(br.readLine());
        A = new int[n];
        for(int i=0;i<n;i++){
            // (-1000 ~ 1000)
            A[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dP());
    }
    static int dP(){
        int []dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];

        for(int i=1;i<n;i++){
            // 이전까지의 최대합 + A[i] , A[i] 중 최댓값을 dp에 저장
            // A[i]가 더 큰 경우, dp값을 현재 수열의 값으로 변경
            dp[i] = Math.max(dp[i-1]+A[i], A[i]);
            max = Math.max(max,dp[i]); // dp값중 최대값 찾기
        }

        return max;
    }
}
