# 중량 제한 
'''
https://www.acmicpc.net/problem/1939
이진 탐색 -> 뭘 탐색할건지 ? -> 중량

중량을 이진탐색으로 정해서 공장 1에서 공장 2로 보내봄 
공장 2로 도착 성공하면 -> 더 무거운 중량으로 보내봄 
공장 2로 도착 실패하면 -> 더 가벼운 중량으로 보내봄

중량제한 초과는 다리 못건넘 
'''
from collections import deque

def bfs(weight):
    visited = [0 for _ in range(N+1)]
    q = deque()
    q.append(factory1) # 공장 1을 출발지점으로 
    visited[factory1] = 1
    
    while q:
        now = q.popleft()
        for index in range(len(graph[now])):
            if weight <= graph[now][index][1] and visited[graph[now][index][0]] == 0: # 중량 제한 이하의 무게이고 방문안했으면
                q.append(graph[now][index][0]) # 방문 
                visited[graph[now][index][0]] = 1
    
    if visited[factory2]: # 방문 성공하면 
        return True # True 반환
    else: # 방문 실패하면 
        return False # False 반환
    

N, M = map(int,input().split()) # 섬의 개수, 다리 정보 개수 

graph = [[] for _ in range(N+1)] # [[[연결된 노드, 중량제한]]] 

max_weight = 0 # 최대 중량 초기값 / 중량 제한보다 높은 중량은 없으니까 입력받으면서 최대 중량제한 받아놓기 , 왜냐면 최대 중량 제한 = 가능한 최대 중량
for _ in range(M):
    node1, node2, weight = map(int,input().split())
    # 연결된 섬 추가 
    graph[node1].append([node2,weight])
    graph[node2].append([node1,weight])
    # 최대 중량 비교 
    if max_weight < weight:
        max_weight = weight

# 공장 위치 
factory1, factory2 = map(int,input().split())

rlt = 1 # 출력할 최대 무게의 초기값 
min_weight = 1
while min_weight <= max_weight:
    mid_weight = (min_weight + max_weight) // 2
    
    if bfs(mid_weight): # 공장 2로 도착 성공하면 
        min_weight = mid_weight + 1 # 더 무겁게해서 보내봄 
        rlt = mid_weight # 현재기준 마지막 결과 할당
    else: # 공장 2로 도착 실패하면 
        max_weight = mid_weight - 1 # 더 가볍게해서 보내야함
        
print(rlt)