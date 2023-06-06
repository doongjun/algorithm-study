import sys
import heapq
inf = sys.maxsize #최대정수
input = sys.stdin.readline

node, line = map(int, input().split())  #노드 개수, 간선 개수 입력 받기
start_node = int(input()) #시작 노드 입력 받기

graph = [[] for _ in range(node+1)] #그래프 생성
distance = [inf] * (node+1) #거리 그래프 생성

def dijkstra(start):
    q = []  #큐 생성
    heapq.heappush(q, (0, start)) #큐에 시작 값 넣어주고, 시작 값에선 시작 값까지 거리 0 입력
    distance[start] = 0 
    
    while q:  #큐가 빌 때까지
      dist, now = heapq.heappop(q)  #큐에서 거리가 가장 작은 값 빼서 dist에 거리, now에 해당 노드 번호 넣기
      if distance[now] < dist:  #now의 거리가 기존의 최솟값보다 크면 더 볼 필요 없으니까,
          continue  #pass
      
      for i in graph[now]:  #dist가 더 작으면 최솟값을 갱신하기위해 for문 돌림
          cost = dist + i[1]  #지금까지의 거리 + 다음 노드까지의 거리
          if cost < distance[i[0]]: # 돌아서 가는 게 직접 가는 거 보다 짧으면
              distance[i[0]] = cost #짧은 값으로 변경
              heapq.heappush(q, (cost, i[0])) #큐에 새로운 최솟값 넣어주기

for _ in range(line):
    u, v, w = map(int, input().split()) #u에서 v로 가는 거리 w
    graph[u].append((v, w)) 

dijkstra(start_node)  #함수 호출

for i in range(1, node+1):
    if distance[i] == inf:
        print("INF")
    else:
        print(distance[i])