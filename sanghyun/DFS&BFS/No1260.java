import java.io.*;
import java.nio.Buffer;
import java.util.*;

/* 단지붙이기 
https://www.acmicpc.net/problem/2667
Collections객체 다시보기
* */

public class No1260 {
    static StringBuilder sb = new StringBuilder();
    static  int n;
    static  int cnt;

    public  static boolean DFS(int [][] graph,int x,int y, boolean [][]visted){
        // 예외처리
        if(x<=-1 || x>=n || y<=-1 || y>=n){
            return false;
        }

        // 집이 있고, 방문하지 않은 곳이라면
        if( graph[x][y]==1 && visted[x][y] == false){
            visted[x][y]= true;
            cnt++;

            // 상하좌우 살펴보면서 인접하고,방문하지 않은 곳 찾기
            DFS(graph,x-1,y,visted);
            DFS(graph,x,y-1,visted);
            DFS(graph,x+1,y,visted);
            DFS(graph,x,y+1,visted);

            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지도의 크기
        n = Integer.parseInt(st.nextToken());
        int [][] graph = new int[n][n];

        // graph 입력받기
        int elem;
        for(int i=0; i<n;i++){
            String str= br.readLine();
            for(int j=0;j<n;j++) {
                /* 입력받는 부분 다시 볼 것*/
                graph[i][j] =Character.getNumericValue(str.charAt(j));
            }
        }

        // 방문체크하기 위한 메모리할당
        boolean visited [][] = new boolean[n][n];
        // 단지별 집의 수
        List<Integer> home = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cnt=0;
                if( DFS(graph,i,j,visited)==true){
                    home.add(cnt);
                }
            }
        }

        /* 기본적으로 오름차순 정렬 , 파라미터로 List값을 갖음(collection객체) */
        Collections.sort(home);
        sb.append(home.size()).append("\n");
        for(int i : home){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}