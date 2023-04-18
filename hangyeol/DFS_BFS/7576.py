# 토마토마토

'''
https://www.acmicpc.net/problem/7576
익은 토마토의 인접한(동서남북) 익지않은 토마토는 하루가 지나면 익음
며칠이 지나야 모든 토마토가 익는지 그 일수를 반환 
첨부터 모든 토마토가 익어있으면 0출력 
토마토가 모두 익지 못하면 -1 
'''
from collections import deque

def bfs():
    global day

    # 동서남북 탐색용
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    while q: # 큐 빌때까지
        y,x = q.popleft()
        # 탐색 시작 
        for v in range(4):
            ny, nx = y + dy[v], x + dx[v] # 탐색하고 있는 좌표 
            # 범위 안에 있고 방문안했고 익지 않은 토마토면 
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == -1 and box[ny][nx] == '0':
                # 익은걸로 변하고
                box[ny][nx] = '1' 
                # 큐에 넣고 
                q.append((ny,nx))
                # 방문체크 
                visited[ny][nx] = visited[y][x] + 1
    
    # 마지막으로 토마토 상자 검사
    for n in range(N):
        for m in range(M):
            if box[n][m] == '0': # 안익었으면 
                return True 
            elif box[n][m] == '1': # 익었으면 
                if visited[n][m] > day: 
                    day = visited[n][m] # 익는데 걸린 시간 할당 
    
    return False
                

#가로, 세로 
M, N = map(int,input().split())

box = []
q = deque() 
counts = 0 # 시작부터 익어있는 토마토 개수 세기  
visited = [[-1]*M for _ in range(N)] #방문체크용
# 입력 받으면서 시작점 큐에 넣기 
for row in range(N):
    arr = input().split()
    for col in range(M):
        if arr[col] == '1': # 익어있으면 
            q.append((row,col)) # 시작점 큐에 넣기 
            visited[row][col] += 1
        elif arr[col] == '0':
            counts += 1 # 안익은 토마토 카운트 


            
    box.append(arr) # 토마토 한줄 box에 넣기 

if q: # 익은 토마토 있으면 
    # 안익은 토마토 있으면 bfs 실행
    if counts:
        day = -1
        if bfs(): # 안익은 토마토 있으면 
            print(-1) # 실패
            exit()
        else: # 없으면 
            print(day) # 익는데 걸리는 시간 출력
            exit()
    # 안익은거 없으면 첨부터 다 익은거니까 
    else:
        print(0) # 0 출력 
        exit()
else: # 익은 토마토 없으면 
    print(-1) # 평생 못 익힘 
    exit()