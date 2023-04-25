/*
전화번호 목록
* https://www.acmicpc.net/problem/5052
문자열, 처음에 정렬(사전순)해서 최소길이 체크안함
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 테스트케이스

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 전화번호의 수
            String phoneNum[] = new String[n];

            // 전화번호의 수 만큼 반복
            for(int i=0;i<n;i++){
                phoneNum[i] = br.readLine(); // 문자열로 전화번호 입력받기
            }
            Arrays.sort(phoneNum); // 사전순 정렬


            boolean flag = true;
            for(int i=0;i<n-1;i++){
                int len = Math.min(phoneNum[i].length(), phoneNum[i+1].length()); // 처음에 정렬되있어서 최솟값 안찾았음

                if(phoneNum[i].substring(0,len).equals(phoneNum[i+1].substring(0,len)) ) // 인접한 문자열 비교
                {
                    // 접두어인 경우
                    flag =false;
                    break;
                }
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}