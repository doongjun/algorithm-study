#혼자 못 풀어서 답에서 아이디어 얻고 다시 품


from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int,  input().split()) #n: 섬의 개수, m: 다리의 개수
graph = [[] for _ in range(n+1)]  #그래프 만들기

def bfs(c):
    q = deque()
    q.append(factory_1)
    visited = [False] * (n+1) #visited 생성
    visited[factory_1] = True #초기 값 방문처리

    while q:
        x = q.popleft()

        for i, w in graph[x]:
            if not visited[i] and w >= c: #연결된 섬은 방문하지 않았으면서 중량이 mid 보다 크거나 같다면,
                visited[i] = True #연결된 섬 방문처리
                q.append(i) #q에 추가
    if visited[factory_2]:  #q를 다 돌려서 끝났을 때, 마지막 섬도 방문했는지 확인하고 방문했었으면
        return True #True 리턴
    else: #안 했으면 
        return False  #False 리턴

for _ in range(m):
    a, b, weight = map(int, input().split())
    graph[a].append((b, weight))
    graph[b].append((a, weight))

start, end = 1, 1000000000  #문제 조건에 나와 있는 최소, 최대 중량
ans = 0 #정답
factory_1, factory_2 = map(int, input().split())  #공장이 위치해 있는 두 섬

while start <= end: 
    mid = (start + end) // 2

    if bfs(mid):  #bfs 돌렸을 때 True 나오면,
        ans = mid #그때의 mid 값을 정답에 넣기
        start = mid + 1 
    else: #False일 때
        end = mid - 1

print(ans)  #정답 출력