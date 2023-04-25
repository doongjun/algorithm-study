import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2468 {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] coordinates = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }

        for (int h=min-1; h<=max; h++) {
            visited = new boolean[n][n];
            int safetyZoneCount = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (isNotFlooded(i, j, h)) {
                        dfs(new Node(i, j), h);
                        safetyZoneCount++;
                    }
                }
            }

            answer = Math.max(answer, safetyZoneCount);
        }

        System.out.println(answer);
    }

    static void dfs(Node node, int h) {
        visited[node.x][node.y] = true;
        for (int[] coordinate: coordinates) {
            int nx = node.x + coordinate[0];
            int ny = node.y + coordinate[1];

            if (isNotFlooded(nx, ny, h)) {
                dfs(new Node(nx, ny), h);
            }
        }
    }

    static boolean isNotFlooded(int x, int y, int h) {
        return x>=0 && x<n && y>=0 && y<n && graph[x][y]>h && !visited[x][y];
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
