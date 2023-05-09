# DFS와 BFS
'''
https://www.acmicpc.net/problem/1260
'''
from collections import deque

def dfs(s):
    # 종료조건 
    if sum(visited_dfs) == N:
        return
        
    for v in graph[s]:
        if visited_dfs[v] == 0: # 방문안했으면 
            visited_dfs[v] = 1 # 방문체크하고 
            rlt_dfs.append(v)
            dfs(v)
            
def bfs(s):
    q = deque()
    q.append(s) # 시작점 인큐
    visited_bfs[s] = 1 # 시작점 인큐 체크
    while q: 
        x = q.popleft() # 큐에서 꺼냄 
        rlt_bfs.append(x) # 방문한 노드 결과에 넣어줌 
        for v in graph[x]: # 해당 정점과 연결된 정점 확인 
            if visited_bfs[v] == 0: # 인큐 안했던 정점이면 
                q.append(v) # 인큐
                visited_bfs[v] = 1 # 인큐 체크     


# 정점의 개수, 간선의 개수, 시작 번호    
N,M,V = map(int,input().split())

# index : 정점 번호 / 해당 정점과 연결된 정점을 담은 리스트 
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split()) 
    graph[a].append(b)
    graph[b].append(a)
    

# 그래프 크기 순으로 정렬 
for i in range(1,N+1):
    graph[i].sort()

# 방문 체크용
visited_dfs = [0]*(N+1)
visited_dfs[V] = 1 # 시작점 

visited_bfs = [0]*(N+1)

# 결과 출력용 
rlt_dfs = [V]
dfs(V)
print(*rlt_dfs)
rlt_bfs = []
bfs(V)
print(*rlt_bfs)