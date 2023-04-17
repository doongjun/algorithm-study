# 안전영역 
'''
https://www.acmicpc.net/problem/2468
모든 비의 양에 따른 경우의 수 다 세야되니까 더 빠른 bfs로 ㄱ
'''
from collections import deque

def bfs(r,c,rain):
    '''
    param
    r : 시작점 row
    c : 시작점 column
    rain : 현재 오는 비의 양
    '''
    # 탐색 방향 
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    # 큐 생성 및 시작 점 큐에 인큐 
    q = deque()
    q.append((r,c))
    visited[r][c] = 1 # 인큐 체크 
    while q: # 큐가 빌때까지
        y, x = q.popleft() # 디큐 
        for v in range(4):
            ny, nx = y + dy[v], x + dx[v]
            # 범위 안에 있고 방문안했고 비가 오는 양 이상이면 
            if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] >= rain:
                q.append((ny,nx)) # 인큐
                visited[ny][nx] = 1  # 인큐체크 

# 행,열의 크기 
N = int(input())
# 지역의 높이정보 
arr = []
# 제일 높은 빌딩의 높이
h = 0 # 초기값
for _ in range(N):
    line = list(map(int,input().split()))
    h_now = max(line)
    if h < h_now: # 현재까지의 제일 높은 빌딩 높이보다 크면 
        h = h_now # 할당
    arr.append(line) 

max_counts = 0
for rain in range(0,h+2): # 비가 오는 양 (비가 오는 양이 더 크면 잠긴거라고 하자)
    visited = [[0]*N for _ in range(N)] # 방문체크용
    counts = 0 # rain만큼 비가오는 상황에서 안전한 영역의 개수
    for row in range(N):
        for col in range(N):
            # 높이가 비가 오는 양 이상이고 방문 안했으면
            if arr[row][col] >= rain and visited[row][col] == 0:
                bfs(row,col,rain)# 출발
                counts += 1 # 안전한영역 + 1
    
    if max_counts < counts: # 맥카 보다 크면 
        max_counts = counts # 할당

print(max_counts)