import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1012 {
    static int[][] coordinates = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] graph;
    static boolean[][] visited;
    static int m, n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[m][n];
            visited = new boolean[m][n];

            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            int earthwormCount = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (isCabbage(i, j)) {
                        dfs(i, j);
                        earthwormCount++;
                    }
                }
            }

            System.out.println(earthwormCount);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int[] coordinate: coordinates) {
            int nx = x + coordinate[0];
            int ny = y + coordinate[1];

            if (isCabbage(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    private static boolean isCabbage(int x, int y) {
        return isValidCoordinate(x, y) && graph[x][y]==1 && !visited[x][y];
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x>=0 && x<m && y>=0 && y<n;
    }

}
