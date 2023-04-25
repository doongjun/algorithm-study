import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2470 - 두 용액
 */
public class No2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }
        Arrays.sort(arr); // 정렬

        int[] answer = new int[2]; // 정답
        int mem = Integer.MAX_VALUE; // 절대값이 0에 가까운 값을 임시 저장
        int min = 0; // 최소 index
        int max = n-1; // 최대 index
        while (max > min) {
            int sum = arr[min]+arr[max];
            int abs = Math.abs(sum);

            // 0 이면 정답 출력하고 종료
            if (abs == 0) {
                System.out.println(arr[min] + " " + arr[max]);
                return;
            }

            // mem 보다 0에 가까우면 기록
            if (abs < mem) {
                mem = abs;
                answer[0] = arr[min];
                answer[1] = arr[max];
            }

            if (sum > 0) max--;
            else min++;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}

/**
 * - input 1
 * 5
 * -2 4 -99 -1 98
 *
 * - output 1
 * -99 98
 */