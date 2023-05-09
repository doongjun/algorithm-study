import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1260 {
    static StringBuffer sb = new StringBuffer();

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n,m,v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            line = br.readLine();
            st = new StringTokenizer(line," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        graph.forEach(Collections::sort);

        visited = new boolean[n+1];
        dfs(v);

        sb.append(System.lineSeparator());

        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb.toString());
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int next: graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        sb.append(node).append(" ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next: graph.get(cur)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    sb.append(next).append(" ");
                }
            }
        }
    }
}
