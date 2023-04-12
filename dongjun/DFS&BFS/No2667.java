import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2667 {
    static int[][] coordinates = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int houseCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        n = Integer.parseInt(line);
        graph = new int[n][n];
        visited = new boolean[n][n];

        // init graph
        for (int i=0; i<n; i++) {
            line = br.readLine();
            for (int j=0; j<n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> houseCounts = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (isHouse(i, j)) {
                    dfs(i, j);
                    houseCounts.add(houseCount);
                    houseCount = 0;
                }
            }
        }
        Collections.sort(houseCounts);

        System.out.println(houseCounts.size());
        for (int houseCount: houseCounts) {
            System.out.println(houseCount);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        houseCount++;
        for (int[] coordinate: coordinates) {
            int nx = x + coordinate[0];
            int ny = y + coordinate[1];

            if (isHouse(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    private static boolean isHouse(int x, int y) {
        return isValidCoordinate(x, y) && graph[x][y]==1 && !visited[x][y];
    }

    private static boolean isValidCoordinate(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

}
