import java.io.*;
import java.nio.Buffer;
import java.util.*;
/* 숨바꼭질
https://www.acmicpc.net/problem/1697
queue의 사이즈를 직접 사용하여 add시 size가 변했음
* */
public class No1697 {
    static boolean []visited = new boolean[100001];
    static int result=0;
    public static int BFS(int N,int K){
        Queue<Integer> q = new LinkedList<>();
        q.add(N); // 시작점
        visited[N] =true; // 방문체크

        while(!q.isEmpty()){
            /* 사이즈를 직접사용하여 큐가 add되면 size가 변했음*/
            int size = q.size();
            for(int i=0;i<size;i++){
                int elem = q.poll(); // 최상단 큐 꺼내기

                if(elem == K){ // 도착지점
                    return result;
                }

                for(int j =0;j<3;j++){
                    int dx = elem;
                    if(j==0) {
                        dx = elem-1;
                    }
                    else if(j==1){
                        dx = elem+1;
                    }
                    else{ // j==2
                        dx = elem*2;
                    }
                    if(dx>=0 && dx<=100000 && visited[dx]==false){
                        q.add(dx);
                        visited[dx]= true;
                    }
                }
            }
            result++;
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = BFS(N,K);
        System.out.println(result);
    }
}