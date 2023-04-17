# 미로탐색 
'''
https://www.acmicpc.net/problem/2178
1 : 이동할 수 있는 칸 
0 : 이동할 수 없는 칸

(0,0) 에서 (N-1,M-1) 까지 이동할 때 지나야 하는 최소 칸 수 구하기 (count에는 출발, 도착점도 포함)
bfs로 하면 비교 없이 최소 이동 칸 구할 수 있음
'''
from collections import deque
def bfs(y,x):
    '''
    param
    y,x : 시작점의 row,column
    '''
    # 주변탐색 용 (위,아래,왼,오른)
    dx = [0,0,-1,1] 
    dy = [-1,1,0,0] 
    q = deque() # 큐 생성
    q.append((y,x)) # 시작점 큐에 Enqueue
    visited[y][x] = 1 # Enqueue 체크 및 이동 count
    while q: # q 빌때 까지 
        r,c = q.popleft() # Dequeue
        # 인접한 곳 탐색 
        for i in range(4):
            ny, nx = r + dy[i], c + dx[i]
            # 범위 안에 있고 Enqueue 한적 없고 이동할 수 있는 칸이면 
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and graph[ny][nx] == '1':
                q.append((ny,nx)) # Enqueue
                visited[ny][nx] = visited[r][c] + 1 # Enqueue 체크

# row, column
N,M = map(int,input().split())

graph = [input() for _ in range(N)]

visited = [[0]*M for _ in range(N)] # Enqueue 체크용

bfs(0,0)
# print(visited)
print(visited[N-1][M-1])