n = int(input()) #컴퓨터 수
c = int(input()) #연결 되어 있는 수

graph = [[] for _ in range(n+1)] #그래프 생성
visited = [[] for _ in range(n+1)] #visited 생성

#연결지어주기
for _ in range(c):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)



ans = 0  # 정답

def dfs(x):

    visited[x] = True  #방문체크
    global ans         
    ans += 1    #감염된 컴퓨터 수 +1
    for i in graph[x]:
        if not visited[i]: #방문 안 했으면
            dfs(i)   #재귀      

dfs(1)
print(ans - 1)  #1번꺼 제외해야함