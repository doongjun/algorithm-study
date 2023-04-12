import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = br.readLine();
        st = new StringTokenizer(line, " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        int second = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int cur = queue.poll();
                if (cur == k) return second;

                int[] nextSteps = {cur+1, cur-1, cur*2};
                for (int nextStep: nextSteps) {
                    if (isValid(nextStep)) {
                        queue.offer(nextStep);
                        visited[nextStep] = true;
                    }
                }
            }
            second++;
        }

        return -1;
    }

    private static boolean isValid(int location) {
        return location >= 0 && location <= 100000 && !visited[location];
    }
}
