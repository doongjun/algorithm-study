import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2178 {
    static int[][] coordinates = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] graph;
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = line.charAt(j)-'0';
            }
        }

        bfs(new Node(0, 0));
        System.out.println(graph[n-1][m-1]);
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        visited[node.x][node.y] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int[] coordinate: coordinates) {
                int nx = cur.x + coordinate[0];
                int ny = cur.y + coordinate[1];

                if (isValidCoordinate(nx, ny)) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[cur.x][cur.y]+1;
                }
            }
        }
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m && graph[x][y] == 1 && !visited[x][y];
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
