/*
* 숨바꼭질 3
* https://www.acmicpc.net/problem/13549
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No13549 {
    static class Node implements Comparable<Node>{ // 우선순위를 결정하기위해 comparable
        private int index;
        private int time;

        public Node(int index,int time){
            this.index = index;
            this.time = time;
        }

        // 거리가 짧은 것이 높은 우선순위를 갖도록
        /* 현재객체가 other보다 작을경우 -1
         *  현재객체와 other가 동일한 경우 0
         *  현재객체가 other보다 클 경우 1
         * */
        @Override
        public int compareTo(Node other) { // 현재 객체와 다른 객체를 비교
            if(this.time < other.time){
                return -1;
            }
            return 1;
        }
    }
    public static final int INF = (int)1e9;
   public static int n,m;
    public static int []d = new int[100001]; // 이동시간
   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 출발지점과 도착지점
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 무한대로 초기화
        Arrays.fill(d,INF);

        // 다익스트라 알고리즘을 수행
        int t = dijkstra(n,m);

        // 출력
       System.out.println(t);
    }

    public static int dijkstra(int start,int goal) {
        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 큐에 시작노드와 시간 0 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;

        // 큐가 빌때까지
        while (!pq.isEmpty()) {
            // 가장 최단거리가 짧은 노드에 대한 정보를 우선순위큐로 꺼내기
            Node node = pq.poll();
            int time = node.time;
            int now = node.index;

            if (now == goal) {
                return d[goal];
            }
            // 순간이동한 경우
            if (now * 2 <= 100000 && time < d[now * 2]) {
                // 시간변화 없음
                d[now * 2] = time;
                pq.offer(new Node(now * 2, time));
            }

            // - 1 칸 이동한 경우
            if (now - 1 >= 0 && time + 1 < d[now - 1]) {
                // 시간 +1
                d[now - 1] = time + 1;
                pq.offer(new Node(now - 1, time + 1));
            }

            // + 1 칸 이동한 경우
            if (now + 1 <= 100000 && time + 1 < d[now + 1]) {
                // 시간 +1
                d[now + 1] = time + 1;
                pq.offer(new Node(now + 1, time + 1));
            }
        }
        return -1;
    }
}