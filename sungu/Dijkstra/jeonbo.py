import sys
import heapq
input = sys.stdin.readline

node, line, start = map(int, input().split()) #노드, 간선, 시작점 입력받기
inf = int(1e9)  #최대정수

graph = [[] for i in range(node+1)] #그래프 그리기
distance = [inf] * (node+1) #쵳단 거리 그래프 그리기

for _ in range(line): #그래프에 간선 입력
    x, y, z = map(int, input().split())
    graph[x].append((y,z))

def dijkstra(start):
    q = []  #큐 생성
    heapq.heappush(q, (0, start)) #큐에 초기값 세팅
    distance[start] = 0 #시작 노드 까지 0
    while q:
        dist, now = heapq.heappop(q)  #최솟값 꺼내기
        if distance[now] < dist:  #최단 거리가 방금 꺼낸 값보다 짧으면 무시
            continue
        for i in graph[now]:  #해당 노드에 연결되어있는 노드들
            cost = dist + i[1]  #해당 노드까지의 거리 + 다음 노드까지의 거리
            if cost < distance[i[0]]: #최단거리 보다 더 가까우면
                distance[i[0]] = cost #최소 거리로 교체
                heapq.heappush(q, (cost, i[0])) #다시 큐에 넣어주기

dijkstra(start)

count = 0
max_distance = 0

for d in distance:
    if d != 1e9:  #갈 수 있는 노드면
        count += 1  #1더하기
        max_distance = max(max_distance, d)

print(count -1, max_distance)