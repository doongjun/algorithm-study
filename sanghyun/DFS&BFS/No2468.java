
/* 안전영역
https://www.acmicpc.net/problem/2468
아무 지역도 잠기지 않는부분 생각 (높이는 1~100까지)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No2468 {
    static int n;
    static boolean [][]visited;
    static int [][]graph;
    static int max;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0,- 1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        int max_h = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 입력 받으면서 최대높이 찾기
                if(graph[i][j] > max_h){
                    max_h = graph[i][j];
                }
            }
        }

        // 각 높이마다 DFS반복
        max =-1;
        for(int h=0;h<=max_h;h++){ /* 아무 지역도 잠기지 않으려면 0부터 시작해야함 */
            visited = new boolean[n][n]; // 방문처리 초기화
            int cnt=0;
            // 안전한곳 탐색
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && graph[i][j] > h){ // 방문하지 않았고, 현재 높이보다 높은경우
                        cnt += DFS(h,i,j);
                    }
                }
            }

            max = Math.max(max,cnt); // 최댓값 함수
            /*if(max < cnt)
                max = cnt;*/
        }
        System.out.println(max);
    }

    public static int DFS(int h,int x,int y){
        visited[x][y] = true; // 방문체크

        for(int i=0;i<4;i++){
            int mx = x+dx[i];
            int my = y+dy[i];

            if(mx<0 || my<0 || mx >= n || my >= n) continue;
            if(visited[mx][my]) continue;
            if(graph[mx][my] > h){ // 높이가 더 높은곳이면 탐색
                DFS(h,mx,my);
            }
        }
       // 탐색 마치면
        return 1;

    }
}