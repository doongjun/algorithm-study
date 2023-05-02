#고민해야할할것 1.익은 토마토가 여러개인 경우 2.다 익지 못하는 경우는: 그래프에서 0이 존재하면 -1 
import sys
input = sys.stdin.readline
sys.stdin = open("input.txt")
from collections import deque


m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
q = deque()

#그래프 탐색 후 토마토 익었으면,
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            #큐에 추가
            q.append([i, j])

#동서남북
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
while q:
    x, y = q.popleft()
    for i in range(4):
      
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m:
            #토마토가 안 익었으면,
            if graph[nx][ny] == 0:
                #익는다
                graph[nx][ny] = graph[x][y] + 1
                q.append([nx, ny])

ans = 0

#안 익은 토마토 만나면
for i in graph:
    for j in i:
        if j == 0:
            #-1 출력
            print(-1)
            #종료
            exit()
    ans = max(ans, max(i))

#
print(ans-1)