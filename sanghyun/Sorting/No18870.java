/*
좌표압축
* https://www.acmicpc.net/problem/18870
hashMap 공부
input 시간초과보다 출력시 시간초과
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 배열의 크기
        int N = Integer.parseInt(br.readLine());
        int [] x = new int[N];

        // 입력 받기
        String []input = br.readLine().split(" ");
        for(int i=0;i<input.length;i++){
            x[i] = Integer.parseInt(input[i]);
        }

        int [] temp = x.clone(); // 임시복사 // O(nlogn)
        Arrays.sort(temp); // temp 정렬 // O(nlogn)
        int cnt=0;
        //  key,value 를 갖는 hashmap
        HashMap<Integer,Integer> hMap = new HashMap<>();
        for(int i=0;i<N;i++){
            /* containsKey는 key값이 (temp[i])와 같으면 true ,없으면 false */
            if(!hMap.containsKey(temp[i])) // 중복값 제거 가능
                hMap.put(temp[i],cnt++); //temp[i]를 키로 갖고, cnt를 value
        }

        for(int i=0;i<N;i++){
            // HashMap에서 x[i]를 key로 하는 값 반환
            int result = hMap.get(x[i]); // 입력 받은 순서대로 반환함
            sb.append(result).append(" ");
        }
        System.out.println(sb.toString());
    }
}
