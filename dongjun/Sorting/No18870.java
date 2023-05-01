import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 18870 - 좌표 압축
 */
public class No18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> sortedAndDistinctList = new ArrayList<>(); // 정렬 and 중복제거된 리스트
        Set<Integer> mem = new HashSet<>();
        HashMap<Integer, Integer> rankingTable = new HashMap<>(); // 랭킹 정보 저장하기 위한 HashMap

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;

            // 메모리에 존재하지않으면 추가 -> 중복 제거 위함
            if (!mem.contains(value)) {
                sortedAndDistinctList.add(value);
                mem.add(value);
            }
        }
        Collections.sort(sortedAndDistinctList); // 정렬

        // 순위 테이블에 기록 -> input 1에 대한 예시) { -10: 0, -9: 1, 2: 2, 4: 3 }
        for (int ranking=0; ranking<sortedAndDistinctList.size(); ranking++) {
            rankingTable.put(sortedAndDistinctList.get(ranking), ranking); // hashMap.put(key, value)
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int ranking = rankingTable.get(arr[i]);
            sb.append(ranking).append(" ");
        }
        System.out.println(sb);
    }
}

/**
 * - input 1
 * 5
 * 2 4 -10 4 -9
 *
 * - output 1
 * 2 3 0 3 1
 */