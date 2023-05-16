import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1753 - 최단경로
 */
public class No1753 {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] distanceTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        distanceTable = new int[v+1];
        for (int i=0; i<v+1; i++) {
            graph.add(new ArrayList<>());
            distanceTable[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        dijkstra(k);

        for (int i=1; i<distanceTable.length; i++) {
            if (distanceTable[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(distanceTable[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    /**
     * Fill the shortest distance from the start node to each node
     * @param start start node index
     */
    static private void dijkstra(int start) {
        PriorityQueue<Edge> heap = new PriorityQueue<>();
        heap.offer(new Edge(start, 0));
        distanceTable[start] = 0;

        while (!heap.isEmpty()) {
            Edge cur = heap.poll();
            if (distanceTable[cur.to] < cur.cost) continue;

            for (Edge next: graph.get(cur.to)) {
                int cumCost = cur.cost+next.cost;
                if (cumCost < distanceTable[next.to]) {
                    distanceTable[next.to] = cumCost;

                    heap.offer(new Edge(next.to, cumCost));
                }
            }
        }
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
 * 5 6
 * 1
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 */