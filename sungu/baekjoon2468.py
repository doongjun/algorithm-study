#그래프 생성 후 값 입력 받음
#1~100 차례로 for 문 돌면서 각 높이에서 bfs 활용해서 안전한 영역이 몇개 나오는지 ans에 추가
#ans값중에 max 값 출력
from collections import deque


n = int(input())
#최종 정답 넣을 리스트
ans = []

#-------------------------------------------------------------------------------

def bfs(x, y):
    #상하좌우 탐색
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    q = deque()
    q.append((x, y))

    visited[x][y] =  True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            #그래프 범위 안 넘고 방문하지 않고 비에 잠기지 않았다면
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] > h:
                #방문처리
                visited[nx][ny] = True
                q.append((nx, ny))

#-------------------------------------------------------------------------------------------

#그래프 생성하고 값 입력 받기
graph = [list(map(int, input().split())) for _ in range(n)]

#비가 오는 경우 (0~100) for문 돌리기
for h in range(0,101):
    cnt = 0
    visited = [[False]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            #방문하지 않았고, 해당 지점이 비 높이보다 높을 경우
            if visited[i][j] == False and graph[i][j] > h:
                #bfs 실행
                bfs(i, j)
                #안전 지역 갯수 추가
                cnt += 1

    #높이당 안전 지역이 몇개인지 ans 리스트에 추가
    ans.append(cnt)

#ans 오름차순 정렬
ans.sort()
#최댓값 출력
print(ans[-1])