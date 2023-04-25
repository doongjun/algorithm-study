import java.io.*;
import java.nio.Buffer;
import java.util.*;

/*바이러스
* https://www.acmicpc.net/problem/2606
* */


public class No2606 {
    static int adj;
    public  static  void DFS(int [][]graph,int start,boolean[] visited){
        // 방문처리
        visited[start]=true;

        for(int j = 1; j<graph.length;j++){
            if(graph[start][j]== 1 && visited[j]==false){
                adj++;
                DFS(graph,j,visited);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());

        int [][] graph = new int[node+1][node+1];
        boolean visted[] = new boolean[node+1];

        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 인접노드 1세팅
            graph[x][y] = graph[y][x] =1;
        }

        adj=0;
        // 시작 1에서
        DFS(graph,1,visted);
        System.out.println(adj);
    }
}