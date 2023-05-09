import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No7576 {
    static int[][] coordinates = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] graph;
    static int[][] tomatoBox; // 거리 계산
    static int n, m;
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        tomatoBox = new int[m][n];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                graph[i][j] = tomato;
                if (tomato == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }

        bfs();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int[] tomatoes: tomatoBox) {
            for (int tomato: tomatoes) {
                answer = Math.max(answer, tomato);
            }
        }
        System.out.println(answer);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Tomato cur = queue.poll();
            for (int[] coordinate: coordinates) {
                int nx = cur.x + coordinate[0];
                int ny = cur.y + coordinate[1];
                if (isValidCoordinate(nx, ny)) {
                    graph[nx][ny] = 1;
                    queue.offer(new Tomato(nx, ny));
                    tomatoBox[nx][ny] = tomatoBox[cur.x][cur.y]+1;
                }
            }
        }
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x>=0 && x< m && y>=0 && y< n && graph[x][y] == 0;
    }

    static class Tomato {
        private int x;
        private int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
