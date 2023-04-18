import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 토마토
https://www.acmicpc.net/problem/7576
토마토가 여러개 익어있는경우,어떻게 해야할지 몰랐음, 한개로만 했었음
탐색해서 전체적인 개수는 알겠는데
최단경로나, 최소의 경우의 수 세는걸 잘모르겠음 => bfs의 깊이
* */
public class No7576 {
    static int M,N; // graph의 size
    static int [][] graph ;
    /* 상하좌우 좌표이동 */
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    /* 이동된 좌표값 */
    static  int mX,mY;
    /* Queue이용해서 BFS구현 */
    static  Queue<Node> q;
    /* x와y좌표를 갖는 노드 클래스 */
    static class Node{
        int x;
        int y;

        public Node(int x,int y){
            this.x= x;
            this.y=y;
        }
    }
    public static void BFS(){
        while(!q.isEmpty()){
            Node node = q.poll();
                for(int i=0;i<4;i++){ // 상하좌우 탐색
                    mX = node.x +dx[i];
                    mY = node.y+dy[i];

                    if(mX<0 || mY <0 || mX>=M|| mY>=N) continue; // 에러처리
                    if(graph[mX][mY]==0){ // 토마토가 덜익은경우
                        q.add(new Node(mX,mY)); // 이동한 좌표 큐값에 add
                        graph[mX][mY] = graph[node.x][node.y]+1; // 그 전 값에서 한칸씩 증가
                    }
                }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // graph의 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        q =new LinkedList<>();

        boolean already = true; // 모든 토마토가 익었는지 확인
        //입력받기
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토 시작지점 찾기
                if(graph[i][j] == 1)
                {
                    q.add(new Node(i,j)); // 익은 토마토의 좌표를 넣기
                }
                // 안익은 토마토가 나오면 체크
                if(graph[i][j] == 0){
                    already = false;
                }
            }
        }

        int cntDay=0,flag=0;
        if(already){ // 모든토마토가 익음
            System.out.println(0);
        }
        else{ // BFS실행
            BFS();
            for(int i=0;i<M;i++)
            {
                for(int j=0;j<N;j++){
                   if(graph[i][j] == 0) // 안익은게 있다면
                       flag =1;
                   // 걸린 시간 구하기
                   cntDay = Math.max(cntDay,graph[i][j]);
                }
            }
            if(flag==1)
                System.out.println(-1);
            else System.out.println(cntDay-1);
        }

    }
}