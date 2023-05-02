/*
두 용액
* https://www.acmicpc.net/problem/2470
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 용액의 수
        int N= Integer.parseInt(st.nextToken());
        long []lArr = new long[N];
        // 입력받기
        String input[] = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            lArr[i] = Integer.parseInt(input[i]);
        }

        // 배열 오름차순정렬
        Arrays.sort(lArr);

        // 정렬된 배열을 앞과 뒤의 인덱스
        int left=0,right=N-1;
        long sum = lArr[left]+lArr[right];
        // 0과의 거리가 제일 적은 idx
        int idxL = left;
        int idxR = right;

        while(left != right){ // 모든 배열을 탐색했을 때,
            long temp = lArr[left] +lArr[right];

            if(Math.abs(temp) < Math.abs(sum)){ // 0과 떨어진거리
                sum = temp;
                idxL = left;
                idxR = right;
            }

            if(temp==0) break;
            else if(temp > 0){
                right--;
            }
            else{ // temp < 0
                left++;
            }
        }
        System.out.println(lArr[idxL]+" "+lArr[idxR]);
    }
}