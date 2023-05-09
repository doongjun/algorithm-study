import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 자릿수
        int n = Integer.parseInt(st.nextToken());
        System.out.println(dP(n));
    }

    public static long dP(int n){
        int dp[][] = new int [n+1][10]; // 길이가 n이고 마지막 숫자가 0~9인 수의 개수
        /* 현재 dp[i][j]는 이전 길이의 j-1로 끝나고 j+1끝나는 수의 합과 같음
        dp[i-1][j-1] + dp[i-1][j+1]과 같음
         ex) 길이가 2이고 3으로 끝나는 수, 23,43
            길이가 1이고 2와 4로 끝나는 수 2,4
        */
        long ans=0;
        // 길이가 1일때, 0으로 끝나는 수는 0
        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){ // 길이가 2이상인 수
            for(int j=0;j<=9;j++){ // 0~9로 끝나는 수
                if(j==0) // 0으로 끝나는 경우
                {
                    dp[i][j] = dp[i-1][1];
                }
                else if(j==9) // 9로 끝나는 경우
                {
                    dp[i][j] = dp[i-1][8];
                }
                else
                {
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % 1000000000;
                }

                if(i==n){ // 구하고자 하는 길이라면
                    ans = (ans + dp[i][j])%1000000000;
                }
            }
        }
        if(n==1){
            return 9;
        }
        else
            return ans;
    }
}