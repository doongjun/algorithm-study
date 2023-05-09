import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1939 - 중량제한
 */
public class No1939 {
    static ArrayList<ArrayList<Island>> graph = new ArrayList<>();
    static boolean[] visited;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Island(b, c));
            graph.get(b).add(new Island(a, c));

            max = Math.max(max, c);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int answer = binarySearch(0, max);
        System.out.println(answer);
    }

    /**
     * 한 번의 이동에서 옮길 수 있는 중량의 최댓값을 찾기 위한 이분탐색
     * @param min - (중량제한)최솟값
     * @param max - (중량제한)최댓값
     * @return 정답
     */
    private static int binarySearch(int min, int max) {
        int lo = min;
        int hi = max;

        // 이분탐색
        while (lo <= hi) {
            int mid = (lo+hi)/2;

            /*
            1. 중량값(mid)를 매개변수로 너비우선탐색
            2. 너비우선탐색 결과가 true 경우 lo = mid+1, 아닐 경우 hi = mid-1
             */
            if (bfs(mid)) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return hi;
    }

    /**
     * graph 너비우선탐색
     * @param weight - 중량값
     * @return 출발지(start)에서부터 도착지(end)까지 weight 제한을 만족하고 모두 건널 수 있는지 탐색 결과 true or false
     */
    private static boolean bfs(int weight) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[graph.size()+1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int point = queue.poll();

            if (point == end) return true; // end point 에 도착

            for (Island island: graph.get(point)) {
                // weight 가 다리의 중량제한보다 낮아야 하고, 방문하지 않았다면 방문처리
                if (weight<=island.cost && !visited[island.to]) {
                    visited[island.to] = true;
                    queue.add(island.to);
                }
            }
        }

        return false; // end point 에 도착하지 못함
    }

    // 섬 객체
    static class Island {
        private int to;
        private int cost;

        public Island(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}