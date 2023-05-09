# 숨바꼭질 
'''
https://www.acmicpc.net/problem/1697
'''

from collections import deque

def bfs(s,e):
    '''
    현재 위치 X일 때 X-1 or X+1 로 이동하는 시간 1초 
    2*X로 이동하는 것도 1초가 걸린다 
    이때 s에서 시작해서 e로 갈때까지 걸리는 최소시간을 구하는 함수 
     
    param
    s : 시작 위치 
    e : 종료 위치
    '''
    global rlt
    visited = [0]*100001
    st = 0 # 이동 시간  
    q = deque()
    q.append(s) # Enqueue
    while q:
        location = q.popleft() # Dequeue 
        dx = [-1,1,location] # -1 걷기, 1 걷기 ,순간이동
        
        # 종료조건 1
        if visited[location] >= rlt: # 현재까지의 최소시간보다 t가 크거나 같다면
            continue # 볼필요없으니 현재 큐 종료 
        
        # 종료조건 2
        elif location == e: # 동생의 위치에 도달하면 
            rlt = visited[location] # 최소시간에 현재 시간을 할당 
            continue
        
        # 탐색시작 
        for i in range(3):
            nx = dx[i] + location
            if 0 <= nx <= 100000 and visited[nx] == 0: # 범위 안에 있고 Enqueue 안했으면 
                q.append(nx)
                visited[nx] = visited[location] + 1 # 이동할 때마다 이동시간 1초 추가 
    
# 수빈이 위치, 동생위치 
N, M = map(int,input().split())
rlt = 123456789 # 최솟값의 초기값
bfs(N,M)
print(rlt)