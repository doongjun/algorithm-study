import sys
inf = sys.maxsize #최대정수

node, line = map(int,input().split()) #노드, 간선 입력받기
graph = [[inf] * (node + 1) for _ in range(node + 1)] #2차워 그래프 그리기

for a in range(1, node+1):  #자기자신으로 가는 거리 0처리
    for b in range(1, node+1):
        if a == b:
            graph[a][b] = 0

for _ in range(line): #각 간선의 거리 입력
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

m, k = map(int, input().split())  #m회사 k회사 위치 입력받기

for k in range(1, node+1):  #플로이드 워셜 알고리즘 이용하여 최소 거리 찾기
    for a in range(1, node+1):
        for b in range(1, node+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

ans = graph[1][k] + graph[k][b] #정답은 1번에서 출발
if ans == inf:  #길이 없다면 -1처리
    print("-1")
else:
    print(ans)