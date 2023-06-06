/*
* 미래도시
* 이코테 다익스트라 문제
* 노드와 간선의 수가 100이하기 때문에 플로이드워셜
* 시간복잡도는 O(n^3)
* 점화식
* Dab = min ( Dab, Dak + Dkb )
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2 {
    // 플로이드 와샬에서 Integer.MAV_VALUE사용시 , +를 해도 더 낮은 숫자가 나옴
    public static final int INF = (int)1e9; // 무한을 의미 10억
   public static int n,m,goal,checkpoint; // ( 1<= n,m<=100 )
    public static int [][]graph = new int[101][101];

   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        // 무한대 값으로 그래프 초기화 (n+1)개
       for(int i =0;i< 101;i++){
           Arrays.fill(graph[i],INF);
       }

       // 자기 자신에서 자신으로 가는 비용은 0으로 초기화
       for(int a=1; a<=n; a++){
           for(int b=1; b<=n; b++){
               if(a==b)
                   graph[a][b] = 0;
               else break;
           }
       }

       // 간선의 정보 입력받아, 그 값으로 초기화
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 모든 이동시간의 비용은 1
            graph[a][b] = graph[b][a] = 1;
        }

        /* 목표지점과 중간지점 입력받기 */
        st = new StringTokenizer(br.readLine());
        goal = Integer.parseInt(st.nextToken());
        checkpoint = Integer.parseInt(st.nextToken());

        // 플로이드 워셜 알고리즘 O(n^3)
       for(int k = 1 ; k<=n; k++){
           for(int a = 1; a<=n; a++){
               for(int b = 1; b<=n; b++){
                   graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
               }
           }
       }

       // 1부터 출발하여 checkpoint까지 가는 비용 + checkpoint부터 goal까지 가는 비용
       int distance = graph[1][checkpoint] + graph[checkpoint][goal];

       if(distance >= INF){ // 도달할 수 없는 경우
           System.out.println(-1);
       }
       else{ // 도달할 수 있는 경우
           System.out.println(distance);
       }

    }
}
/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
* */