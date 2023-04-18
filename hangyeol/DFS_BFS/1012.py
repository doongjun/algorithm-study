# 유기농 배추 
'''
https://www.acmicpc.net/problem/1012
재귀함수 쓰면 메모리 초과남 
반복문을 통해 dfs 구현 
'''
def dfs(r,c):
    visited[r][c] = 1 # 방문체크 
    stack = []
    stack.append((r,c))
    while stack:
        r,c = stack.pop()
        # 인접 동서남북 탐색 시작 
        for v in range(4):
            ny, nx = r + dy[v], c + dx[v] # 탐색하는 좌표 
            # 범위안에 있고 방문안했고 배추면
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and graph[ny][nx] == 1:
                # 지렁이 이동 
                visited[ny][nx] = 1
                stack.append((ny,nx))


# 동서남북 탐색용
dx = [0,0,-1,1]
dy = [-1,1,0,0]

# 테스트 케이스 수
T = int(input())
for tc in range(T):
    # 배추밭의 가로길이, 세로길이, 배추심어져있는 위치의 개수
    M,N,K = map(int,input().split())
    # 밭
    graph = [[0]*M for _ in range(N)]
    # 방문체크용
    visited = [[0]*M for _ in range(N)]
    for _ in range(K):
        # 배추위치
        X, Y = map(int,input().split())
        graph[Y][X] = 1
    
    counts = 0
    for row in range(N):
        for col in range(M):
            #방문안했고 배추면 
            if visited[row][col] == 0 and graph[row][col] == 1:
                # 지렁이 풀기
                counts += 1 # 지렁이 수 + 1
                # 지렁이 출발 
                dfs(row,col)
                # print(visited)

    print(counts)