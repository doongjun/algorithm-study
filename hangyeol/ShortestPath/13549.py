# 백준 숨바꼭질 
'''
https://www.acmicpc.net/problem/13549

현재 위치가 i일 때 
연결된 노드는 i + 1, i - 1, i * 2 라고 하자 
각 링크의 weight는 1, 1, 0이다 
'''
import sys
input = sys.stdin.readline

import heapq

def dijkstra(start,end):
    INF = 10000000000
    distance = [INF for _ in range(100001)]
    distance[start] = 0

    q = []
    heapq.heappush(q,(0,start))

    while q:
        distance_from_start, departures = heapq.heappop(q)
        for weight, arrivals in [(1,departures + 1),(1,departures - 1),(0,departures * 2)]:
            if 0 <= arrivals <= 100000 and distance_from_start + weight < distance[arrivals]:
                distance[arrivals] = distance_from_start + weight
                heapq.heappush(q,(distance[arrivals],arrivals))
    # print(distance[:30])
    print(distance[end])

start_node, end_node = map(int ,input().split())
dijkstra(start_node,end_node)