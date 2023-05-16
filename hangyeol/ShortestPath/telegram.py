# 나동빈 최단 경로 예제 3
'''
links are one way.
we have to find the shortest distance to every node from start node(C).
-> Dijkstra algorithm 
'''
import sys
sys.stdin = open('telegram.txt')
input = sys.stdin.readline

import heapq

def dijkstra(start):
    # distance initialization
    INF = 30000000
    distance = [INF for _ in range(a_number_of_node + 1)]
    distance[0] = 0 # there is not node 0. we don't use it.
    distance[start] = 0 # distance of start to start is 0. 

    # heapq initialization
    q=[]
    heapq.heappush(q, (0,start)) # insert (distance from start, a node to check) in q
    
    # find the shortest distance 
    while q:
        distance_from_start, departures = heapq.heappop(q)

        for weight, arrivals in graph[departures]: # link to arrivals from departures
            if distance_from_start + weight < distance[arrivals]:
                distance[arrivals] = distance_from_start + weight
                heapq.heappush(q,(distance[arrivals],arrivals))

    # find result
    a_number_of_node_to_go = 0
    max_distance = 0
    for i in range(1, a_number_of_node + 1):
        if 0 < distance[i] < INF:
            a_number_of_node_to_go += 1
            if distance[i] > max_distance:
                max_distance = distance[i]
    
    print(a_number_of_node_to_go,max_distance)

a_number_of_node, a_number_of_link, start_node = map(int,input().split())

# make graph
graph = [[] for _ in range(a_number_of_node + 1)] 
for _ in range(a_number_of_link):
    node1, node2, weight = map(int,input().split())
    graph[node1].append((weight,node2))

# start to find distances
dijkstra(start_node)


