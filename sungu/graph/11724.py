import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

def dfs(start):
    visited[start] = True
    for i in graph[start]:
        if not visited[i]:
            dfs(i)

n, m = map(int, input().split())  #노드, 간선 개수 입력 받기
graph = [[] for _ in range(n+1)]  #그래프 생성
visited = [False] * (n+1) #방문처리 그래프 생성
count = 0 #정답 초기값 세팅
for _ in range(m):
    u, v = map(int,input().split()) #간선 끝 점들 입력 받기
    graph[u].append(v)  #간선 그리기
    graph[v].append(u)

for j in range(1, n +1):  #노드 하나씩 돌면서 dfs
    if not visited[j]:
        dfs(j)
        count += 1

print(count)