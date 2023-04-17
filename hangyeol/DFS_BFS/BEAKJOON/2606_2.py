# 바이러스 
'''
https://www.acmicpc.net/problem/2606
연결되어있으면 바이러스 퍼짐 
컴퓨터 100대밖에 없음 
DFS, BFS 둘다 가능할듯
시작노드는 1
'''
def dfs(s):
    global counts
    visited[s] = 1 # 방문체크 
    counts += 1 # 바이러스 걸린 컴퓨터 카운트

    # 연결 노드 탐색 
    if graph[s]: # 연결된 노드 있으면 
        for node in graph[s]:
            if visited[node] == 0: # 방문 안했으면 
                dfs(node)
    
    else: # 연결노드 없으면 
         print()
         return # 함수 종료 
    
N = int(input()) # 컴퓨터(노드)의 수 (1~100번)
M = int(input()) # 직접 연결 되어있는 컴퓨터 쌍의 수 (간선의 수 , 양방향)
visited = [0]*(N+1) # 방문체크 
counts = 0 # 바이러스 걸리는 컴퓨터 수
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
dfs(1)
print(counts-1) # 1번 컴퓨터 제외하고 바이러스 걸린 컴터 수 출력 