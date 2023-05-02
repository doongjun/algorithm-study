import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // 가지고 있는 랜선의 수
        int K = Integer.parseInt(st.nextToken());
        // 원하는 랜선의 수
        int N = Integer.parseInt(st.nextToken());
        long []len_info = new long[K]; // 랜선의 길이 정보

        // 랜선입력 받기 & 최대 랜선길이
        long end = 0; // 끝 idx
        for(int i=0;i<K;i++){
            st= new StringTokenizer(br.readLine());
            len_info[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end,len_info[i]);
        }
        long start = 1; // 시작 idx

        long maxLen = 0;
        while(start<=end) {
            long total =0;
            long mid = (start + end) /2; // start가 0부터이면 end가 1일 때 1/2 => mid =0
            // 떡 자르기
            for(int i=0;i<K;i++){
                total =  total + (len_info[i] / mid); // mid가 0이기때문에 0으로 나눌때 오류
            }
            if(total >= N){ // 원하는 값보다 크면 기준올리기
                maxLen = mid;
                start = mid+1;
            }
            else { // 원하는 작으면 기준 내리기
                end = mid-1;
            }
        }
        System.out.println(maxLen);
    }
}