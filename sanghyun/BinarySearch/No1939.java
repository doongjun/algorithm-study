import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
* ★중량제한
https://www.acmicpc.net/problem/1939
* 인접행렬로 표현해서 메모리초과
* 이분탐색,BFS
* */

public class No1939 {
    static int line,node,start,end;
    static ArrayList<Bridge>[]graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken()); // 섬의 개수
        line = Integer.parseInt(st.nextToken()); // 다리의 개수

        graph = new ArrayList[node+1];
        for(int i=1;i<=node;i++)
            graph[i] = new ArrayList<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int t = 0; t < line; t++) {
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);
            min = Math.min(min, c);

            // 인접리스트로 표현 a와b를 c로 연결
            graph[a].add(new Bridge(b,c));
            graph[b].add(new Bridge(a,c));
        }
        // 시작점과 끝점
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 이진탐색
        int result = 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if(BFS(mid)){ // mid 중량으로 탐색가능하면 줄이기
                result = mid;
                min = mid+1;
            }
            else{ // mid 중량으로 탐색 불가능하면
                max = mid-1;
            }
        }
        System.out.println(result);
    }
    static boolean BFS(int limit) {
        Queue<Bridge> q= new ArrayDeque<>();
        boolean[] visited = new boolean[node+1];
        // 시작지점 탐색
        q.offer(new Bridge(start,0));

        while (!q.isEmpty()){
            Bridge cur = q.poll(); // poll을 통해 현재 리스트로 사용
            // 도착지점이라면
            if(cur.to == end){
                return true;
            }

            for(Bridge next : graph[cur.to]){
                if(next.limit >= limit && !visited[next.to]){
                    // 다음 큐에 삽입하고 방문처리
                    q.offer(next);
                    visited[next.to] =true;
                }
            }
        }
        return false;
    }

    static class Bridge{
        int to,limit;

        Bridge(int to,int limit){
            this.to =to;
            this.limit =limit;
        }
    }
}
