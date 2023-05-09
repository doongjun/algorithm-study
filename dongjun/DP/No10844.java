import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 10844 - 쉬운 계단 수
 */
public class No10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final long MOD = 1000000000;
        int n = Integer.parseInt(br.readLine());
        // dy[n 자릿수][0~9]
        long[][] dy = new long[n+1][10];
        // 첫 번째 자릿수는 항상 1
        for (int i=1; i<10; i++) {
            dy[1][i] = 1;
        }

        // 두 번째 자리수부터 n
        for (int i=2; i<=n; i++) {
            // i 번째 자릿수의 0~9
            for (int j=0; j<10; j++) {
                switch (j) {
                    // 0일 경우 1만 가능
                    case 0:
                        dy[i][j] = dy[i-1][1] % MOD;
                        break;
                    // 9일 경우 8만 가능
                    case 9:
                        dy[i][j] = dy[i-1][8] % MOD;
                        break;
                    // 그 외, 이전 값의 +1, -1의 합
                    default:
                        dy[i][j] = (dy[i-1][j-1]+dy[i-1][j+1]) % MOD;
                        break;
                }
            }
        }

        // dy 경우의 수 합
        long sum = Arrays.stream(dy[n]).sum();
        System.out.println(sum % MOD);
    }
}