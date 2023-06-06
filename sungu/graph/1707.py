import sys
input = sys.stdin.readline
def dfs(start):
    q = []  #큐 생성
    q.append(start) #초기값 넣기
    visited[start] = 1  #초기값도 방문 처리

    while q:
        new = q.pop() #큐에서 하나 뽑아내고,
        for i in graph[new]:  #해당 노드에 연결된 간선들 하나씩 확인
            if visited[i] == visited[new]:  #인접한 노드가 같으면 안 됨
                return False
            
            elif not visited[i]:
                visited[i] = -visited[new]  #해당 값으로 방문 처리
                q.append(i) #큐에 넣어주기
    return True

T = int(input())  #테스크케이스 개수 입력 받기
for _ in range(T):
    node, line = map(int, input().split())  #정점, 간선 개수 입력 받기
    graph = [[] for _ in range(node+1)] #그래프 생성
    visited = [False] * (node+1)  #방문 그래프 생성

    for _ in range(line):
      a, b = map(int, input().split())   #간선 연결
      graph[a].append(b)  
      graph[b].append(a)
    
    for i in range(1, node+1):
        if visited[i] == False:  #방문하지 않은 정점이면,
            if dfs(i) == False:
                print("NO")
                break
    else:
              print("YES")