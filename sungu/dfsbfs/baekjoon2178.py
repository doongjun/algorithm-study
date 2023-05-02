from collections import deque



########### [2] ############

#bfs함수 생성
def bfs(x, y):
    #상하좌우
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    q = deque()
    #큐에 시작 값 넣기
    q.append((x, y))    
    
    #큐가 빌 때까지
    while q:
        
        x, y = q.popleft()

        #상하좌우 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #범위 안에 있고, 길이 있을 경우
            if 0<=nx<n and 0<=ny<m and graph[nx][ny] == 1:
                #큐에 추가
                q.append((nx, ny))
                #거리 1 추가
                graph[nx][ny] = graph[x][y] + 1

    #큐에 값이 없으면 도착지 까지의 거리 return
    return graph[n-1][m-1]


########### [1] ############
n, m = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input())))

print(bfs(0,0))