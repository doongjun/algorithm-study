/*
* 전보
* 이코테 다익스트라 문제
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1 {
    static class Node implements Comparable<Node>{ // 우선순위를 결정하기위해 comparable
        private int index;
        private int distance;

        public Node(int index,int distance){
            this.index = index;
            this.distance = distance;
        }

        public int getIndex(){
            return this.index;
        }

        public int getDistance(){
            return this.distance;
        }


        // 거리가 짧은 것이 높은 우선순위를 갖도록
        /* 현재객체가 other보다 작을경우 -1
        *  현재객체와 other가 동일한 경우 0
        *  현재객체가 other보다 클 경우 1
        * */
        @Override
        public int compareTo(Node other) { // 현재 객체와 다른 객체를 비교
            if(this.distance < other.distance){
                return -1;
            }
            return 1;
        }
    }
    public static final int INF = Integer.MAX_VALUE;
   public static int n,m,start;
   public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int []d = new int[30001];

   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (n+1)개
       for(int i =0;i<=n;i++){
           graph.add(new ArrayList<>());
       }

       // 간선의 정보 입력받기
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // x번 노드에서 y번 노드로 가는 비용이 z
            graph.get(x).add(new Node(y,z));
        }

        // 최단거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d,INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        int count = 0; // 도달할 수 있는 노드의 개수
        int maxDistance = 0; // 가장 멀리 있는 노드와의 최단거리
        for(int i=1;i<=n;i++){
            if(d[i]!=INF){
                count++;
                maxDistance = Math.max(maxDistance,d[i]);
            }
        }

        System.out.println((count-1)+" "+maxDistance);
    }

    public static void dijkstra(int start){
        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 큐에 시작노드와 최단경로 0 삽입
        pq.offer(new Node(start,0));
        d[start] = 0;

        // 큐가 빌때까지
        while(!pq.isEmpty()){
            // 가장 최단거리가 짧은 노드에 대한 정보를 우선순위큐로 꺼내기
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if(d[now] < dist)
                continue; // 현재 노드가 이미 처리된 적이 있는 노드라면 continue

            /* 현재 노드와 연결된 다른 인접한 노드들을 확인 */
            for(int i=0;i<graph.get(now).size();i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance(); // 현재노드에 인접한 i번째 노드에 대한 거리정보와 현재까지의 거리를 더함
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우 갱신
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

}