package code.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 실전문제 2 - 전보
 */
public class Practice2 {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] distanceTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        distanceTable = new int[n+1];
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
            distanceTable[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Edge(y, z));
        }

        dijkstra(c);

        int count = -1; // to exclude start node
        int maxDistance = 0;
        for (int i=1; i< distanceTable.length; i++) {
            if (distanceTable[i] == Integer.MAX_VALUE) continue;

            count++;
            maxDistance = Math.max(maxDistance, distanceTable[i]);
        }

        System.out.println(count + " " + maxDistance);
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
                int cumCost = distanceTable[cur.to]+next.cost;
                if (distanceTable[next.to] > cumCost) {
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
 * 3 2 1
 * 1 2 4
 * 1 3 2
 */