import java.io.*;
import java.nio.Buffer;
import java.util.*;
/*유기농배추
* https://www.acmicpc.net/problem/1012
* */

public class No1012 {
    static StringBuilder sb = new StringBuilder();
    static int M, N;

    public static boolean DFS(int[][] graph, int x, int y, boolean[][] visted) {
        // 예외처리
        if (x <= -1 || x >= M || y <= -1 || y >= N) {
            return false;
        }

        if (graph[x][y] == 1 && visted[x][y] == false) {
            // 방문처리
            visted[x][y] = true;

            // 상하좌우 살펴보면서 인접하고,방문하지 않은 곳 찾기
            DFS(graph, x - 1, y, visted);
            DFS(graph, x, y - 1, visted);
            DFS(graph, x + 1, y, visted);
            DFS(graph, x, y + 1, visted);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 문자열 분리

        // 테스트케이스
        int T = Integer.parseInt(st.nextToken());
        while (T != 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            M = Integer.parseInt(str.nextToken()); // 가로
            N = Integer.parseInt(str.nextToken()); // 세로
            int[][] graph = new int[M][N];

            int K = Integer.parseInt(str.nextToken()); // 배추의 수
            int p, q; // 배추의 위치

            // graph 입력받기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                /* 스캐너로 입력 받는것과 차이 => ? */
                p = Integer.parseInt(st.nextToken());
                q = Integer.parseInt(st.nextToken());
                graph[p][q] = 1;
            }
            boolean visited[][] = new boolean[M][N];

            int bug = 0;

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (DFS(graph, x, y, visited)) {
                        bug++;
                    }
                }
            }
            sb.append(bug).append("\n");

            T--;
        }
        System.out.println(sb);
    }
}