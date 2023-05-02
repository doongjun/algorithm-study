# 그래프를 한칸씩 띄우고, 그래프 범위가 max..(100개)로 시작했기 때문에 범위지정을 따로 해주지 않아도 됨
import sys
#파이썬의 재귀함수 한도가 낮아서 늘려줘야함 !
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

# m,n이 최대 50이므로 넉넉히 100
max = 100

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def dfs(y, x):
  global visited
  #방문처리
  visited[y][x] = True

  #동서남북 탐색
  for i in range(4):
    ny = y + dy[i]
    nx = x + dx[i]
    #배추는 있고, 아직 방문하지 않았다면
    if graph[ny][nx] and not visited[ny][nx]:
      #재귀
      dfs(ny,nx)

#1

#테스트케이스 개수
T = int(input())
for _ in range(T):
    m, n, k = map(int, input().split())
    #비어있는 그래프 생성
    graph = [[False] * max for _ in range(max)]
    #비어있는 visited 생성
    visited = [[False] * max for _ in range(max)]

    #그래프에 배추 심기
    for _ in range(k):
      x, y = map(int, input().split())
      #(0,0)에서 시작하지 않고 (1,1)부터 시작할거기 때문에 1씩 더해줌
      graph[y+1][x+1] = True

    #dfs실행
    cnt = 0
    for i in range(1, n+1):
      for j in range(1, m+1):
        #그래프에 배추가 존재하고, 방문하지 않았다면
        if graph[i][j] and not visited[i][j]:
          #dfs 실행
          dfs(i, j)
          cnt += 1
    
    print(cnt)