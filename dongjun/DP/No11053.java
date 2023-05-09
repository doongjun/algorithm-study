import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11053 - 가장 긴 증가하는 부분 수열
 */
public class No11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dy = new int[n]; // Dynamic Table

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dy[i] = 1;
        }

        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[i], dy[j]+1);
                }
            }
        }

        // Dynamic Table 에서 가장 큰 값
        int answer = Arrays.stream(dy).max().orElse(1);
        System.out.println(answer);
    }
}