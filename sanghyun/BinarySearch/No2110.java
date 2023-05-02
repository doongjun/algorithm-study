/*t
공유기 설치
https://www.acmicpc.net/problem/2110
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // 집의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 공유기 개수 C
        int C = Integer.parseInt(st.nextToken());

        int homes[] = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            homes[i] = Integer.parseInt(st.nextToken());
        }
        // 이진탐색 하기 위해 오름차순 정렬
        Arrays.sort(homes);

        // 최소거리와 최대거리 설정
        int minDistance =1, maxDistance = homes[N-1]-homes[0];

        int ans = 0;
        // 엇갈릴 때까지
        while(minDistance<= maxDistance){
            int prevHome = homes[0]; // 처음 집 공유기 설치
            int cnt =1; // 공유기 설치 개수
            int midDistance = (minDistance+maxDistance)/2; // 중간거리

            for(int i=1;i<N;i++) {
                if (homes[i] - prevHome >= midDistance){
                    cnt++;
                    prevHome = homes[i]; // 공유기 설치한 이전 집을 갱신
                }
            }

            if(cnt>=C){ // 공유기 설치 가능
                ans = midDistance;
                minDistance = midDistance+1;
            }
            else{ // 설치 불가능
                maxDistance = midDistance-1;
            }
        }
        System.out.println(ans);
    }
}