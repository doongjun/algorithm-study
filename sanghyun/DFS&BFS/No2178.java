import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 미로탐색
https://www.acmicpc.net/problem/2178
총 움직인거리는 측정했는데 최소값을 어떻게 체크해야할지 몰랐음
* */

public class No2178 {
    static boolean visited[][]; // 방문체크
    static int dy[] = {-1,1,0,0}; // y좌표 이동
    static int dx[] = {0,0,-1,1}; // x좌표 이동
    static int N,M; // 그래프의 크기
    static int move_x,move_y; // 그래프 탐색하면서 움직일 수 있는 거리
    static int x,y;
    // static int cost;

    static class Node{
        int x;
        int y;

        public Node(int x,int y){
            this.x= x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1;i<=N;i++){
           String input = br.readLine();
            for(int j=1;j<=M;j++){
                graph[i][j] = input.charAt(j-1)-'0';
            }
        }
        BFS(graph,1,1);
        System.out.println(graph[N][M]);
    }

    static void BFS(int[][] graph, int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y)); // 현재 좌표의 노드값을 큐에 add
        visited[x][y] = true;  // 방문처리
        // cost=1;

        while(!q.isEmpty()){
            Node node = q.poll(); // 큐에 있는 노드값 poll
            for(int i=0;i<4;i++){
                move_x = node.x + dx[i];
                move_y = node.y + dy[i];
                // 범위안에서만 체크
                if(move_x>=1 && move_x<=N && move_y>=1 && move_y <= M){
                    // 이동한곳이 방문체크 되어있지않고 길이 있을 때
                    if(!visited[move_x][move_y] && graph[move_x][move_y]==1){
                        visited[move_x][move_y]= true;
                        q.add(new Node(move_x,move_y)); // 이동한 좌표를 큐값에 add
                        graph[move_x][move_y] = graph[node.x][node.y]+1;
                        //System.out.print(move_x +" " + move_y);
                    }

                }
            }
            //System.out.println(" ");
        }
    }
}