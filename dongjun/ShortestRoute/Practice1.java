package code.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실전문제 1 - 미래 도시
 */
public class Practice1 {
    static long[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new long[n+1][n+1];

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                if (i != j) graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i=1; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=1; i<n+1; i++) {
            for (int a=1; a<n+1; a++) {
                for (int b=1; b<n+1; b++) {
                    graph[a][b] = Math.min(graph[a][b], (graph[a][i]+graph[i][b]));
                }
            }
        }

        long distance = graph[1][k] + graph[k][x];
        if (distance >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}

/**
 * 5 7
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 5
 * 4 5
 * 4 5
 */