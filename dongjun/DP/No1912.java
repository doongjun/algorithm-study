import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1912 - 연속합
 */
public class No1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dy = new int[n];
        int max;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = arr[0];
        dy[0] = arr[0];
        for (int i=1; i<n; i++) {
            /**
             * i 이전 값까지의 최댓값 + i 번 값
             * vs
             * i 번 값
             */
            dy[i] = Math.max(dy[i-1]+arr[i], arr[i]);
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);
    }
}