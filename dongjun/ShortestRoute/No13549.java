import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 13549 - 숨바꼭질 3
 */
public class No13549 {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dijkstra(n, k);

        System.out.println(answer);
    }

    /**
     * Update the optimal answer
     * @param start
     * @param end
     */
    private static void dijkstra(int start, int end) {
        Queue<Edge> heap = new LinkedList<>();
        heap.offer(new Edge(start, 0));

        while (!heap.isEmpty()) {
            Edge cur = heap.poll();
            visited[cur.to] = true;

            if (cur.to == end) {
                answer = Math.min(answer, cur.cost);
            }

            Edge[] nextEdges = {
                new Edge(cur.to*2, cur.cost),
                new Edge(cur.to-1, cur.cost+1),
                new Edge(cur.to+1, cur.cost+1),
            };
            for (Edge next: nextEdges) {
                if (!isValid(next.to)) continue;

                heap.offer(new Edge(next.to, next.cost));
            }
        }
    }

    /**
     * Verify param is valid index
     * @param index
     * @return true if valid index
     */
    private static boolean isValid(int index) {
        return (index>=0) && (index<=100000) && !visited[index];
    }

    private static class Edge implements Comparable<Edge> {
        private int to;
        private int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

/**
 * 5 17
 */