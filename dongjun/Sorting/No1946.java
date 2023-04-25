import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1946 - 신입 사원
 */
public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<Overall> overalls = new ArrayList<>();
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int documentRank = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());

                overalls.add(new Overall(documentRank, interviewRank));
            }
            Collections.sort(overalls); // documentRank 기준정렬

            int result = getPassMaxCount(overalls);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    // 선발할 수 있는 신입사원의 최대 인원수 구하는 함수
    private static int getPassMaxCount(ArrayList<Overall> overalls) {
        int topInterviewRank = Integer.MAX_VALUE;
        int count = 0;
        for (Overall overall: overalls) {
            // overall.interviewRank < topInterviewRank
            // 이 조건에 부합하면 선발할 수 있는 신입사원
            if (overall.interviewRank < topInterviewRank) {
                topInterviewRank = overall.interviewRank;
                count++;
            }
        }
        return count;
    }

    // 종합(서류순위, 면접순위) 객체
    private static class Overall implements Comparable<Overall> {
        private int documentRank;
        private int interviewRank;

        public Overall(int documentRank, int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }

        // compareTo 구현
        // documentRank 기준 오름차순
        @Override
        public int compareTo(Overall o) {
            return this.documentRank - o.documentRank;
        }
    }
}

/**
 * - input1
 * 2
 * 5
 * 3 2
 * 1 4
 * 4 1
 * 2 3
 * 5 5
 * 7
 * 3 6
 * 7 3
 * 4 2
 * 1 4
 * 5 7
 * 2 5
 * 6 1
 *
 * - output1
 * 4
 * 3
 */

/**
 * compareTo?
 * - compareTo() 음의 정수를 반환하면 개체가 지정된 개체보다 작다.
 * - compareTo() 0을 반환하면 개체가 지정된 개체와 같다.
 * - compareTo() 양의 정수를 반환하면 개체가 지정된 개체보다 크다.
 */