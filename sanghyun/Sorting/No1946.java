/*
신입사원
* https://www.acmicpc.net/problem/1946
Collections과 사용자정의 정렬 다시보기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class No1946 {
    // 지원자의 정보
    static class Person{
        // 두개의 등수
        int rankA;
        int rankB;

        Person(int a,int b){
            rankA =a;
            rankB =b;
        }

        // 사용자 정의로 정렬하기 위해 (오름차순)
        public int compareTo(Person p){
            if(p.rankA < rankA){
                return 1;
            }else if(p.rankA>rankA){
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int T = Integer.parseInt(st.nextToken()); // 테스트케이스

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 지원자 수
            ArrayList<Person> li = new ArrayList<>(); // 시험성적을 담을 리스트
            // 성적 입력
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int rA = Integer.parseInt(st.nextToken());
                int rB = Integer.parseInt(st.nextToken());
                li.add(new Person(rA,rB)); // new ?
            }
            // 사용자정의 객체를 Comparable 정렬
            Collections.sort(li,Person::compareTo);

            int cnt =1; // 처음한명은 선발
            int cutLine = li.get(0).rankB; // 기준
            // 적어도 하나는 높아야 선발
            for(int i=1; i<N;i++){
                if( cutLine > li.get(i).rankB){ // 커트라인보다 등수가 높으면
                    cnt++; // 선발
                    cutLine = li.get(i).rankB; // 기준점을 현재 선발자의 등수로 변경
                }
            }
            System.out.println(cnt);
        }


    }
}
