/*
* 포도주 시식
* https://www.acmicpc.net/problem/2156
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2156 {
    static int n;
    static int [] wine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 와인의 수 (1<= n <= 10,000)
        n = Integer.parseInt(st.nextToken());
        wine = new int[n+1];

        // 와인의 양 ( 0 ~ 1,000)
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dP());
    }
    /* 연속으로 2잔까지 , 3잔은 마실 수 없음 */
    static int dP(){
        int []dp = new int[n+1];
        // 와인의 수가 1일때의 최적의 해
        dp[1] = wine[1];
        // 와인의 수가 2일때의 최적의 해
        if(n>1)
            dp[2] = wine[1]+wine[2];

        for(int i=3;i<=n;i++){
            // i-1잔까지 마신 최적의 해와,  i-2잔까지 마시고 현재 마신값 중 최대
            dp[i] = Math.max(dp[i-1],dp[i-2]+wine[i]);
            // i-2잔 + 현재 값과, i-3잔까지 마신 최적의해와, 이전과 현재를 마신 값 중 최대
            dp[i] = Math.max(dp[i],dp[i-3]+wine[i-1]+wine[i]);
        }
        return dp[n];
    }
}
