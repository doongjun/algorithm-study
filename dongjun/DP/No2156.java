import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2156 - 포도주 시식
 */
public class No2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dy = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dy[0] = arr[0];

        /**
         * 와인 3잔을 연속해서 마실 수 없음.
         * 각 위치에서 가장 많이 마실 수 있는 경우를 저장
         */
        for (int i=1; i<n; i++) {
            switch (i) {
                case 1:
                    dy[i] = dy[0]+arr[i];
                    break;
                case 2:
                    int x = arr[0]+arr[2];
                    int y = arr[1]+arr[2];
                    dy[i] = Math.max(Math.max(x, y), dy[1]);
                    break;
                default:
                    /**
                     * O : 마심
                     * X : 안마심
                     */
                    int a = dy[i-3]+arr[i-1]+arr[i]; // XOO
                    int b = dy[i-2]+arr[i]; // OXO
                    int c = dy[i-1]; // OOX
                    dy[i] = Math.max(Math.max(a, b), c);
            }
        }

        System.out.println(dy[n-1]);
    }
}