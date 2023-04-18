from collections import deque

#값 입력받기
n,m,v = map(int, input().split())

#그래프 생성
graph = [[False]* (n+1) for _ in range(n+1)]

#간선 그리고 이어주기
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

#visited 생성
visited_1 = [False] * (n+1)
visited_2 = [False] * (n+1)

#dfs생성
def dfs(v):
    #방문처리
    visited_1[v] = True
    #출력
    print(v,end="")
    #탐색 후
    for i in range(1, n+1):
        #방문하지 않고 이어져있다면,
        if not visited_1[i] and graph[v][i]:
            #해당 값 dfs 재귀
            dfs(i)

#bfs 생성
def bfs(v):
    q = deque([v])
    #visited 생성
    visited_2[v] = True
    #큐가 빌때까지
    while q:
        #큐 첫번째 값 뽑기
        v = q.popleft()
        #출력
        print(v,end="")
        #탐색 후
        for i in range(1, n+1):
            #아직 방문하지 않은 곳 발견하면
            if not visited_2[i]:
                #큐에 추가
                q.append(i)
                #방문처리
                visited_2[i] = True


dfs(v)
print()
bfs(v)