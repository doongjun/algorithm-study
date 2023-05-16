# 최단경로 
'''
https://www.acmicpc.net/problem/1753

Find the shortest way to every node from start node.

I'll use dijkstra algorithm and heapq to take out the minimum value.
'''
import sys
input = sys.stdin.readline

import heapq
def dijkstra(start):

    # distance initialization
    distance = [INF for _ in range(a_number_of_nodes + 1)]
    distance[start] = 0 # distance of start node to start node is 0

    q = [] # heapq initialization
    heapq.heappush(q, (0,start))

    while q:
        distance_to_departures_from_start, departures = heapq.heappop(q)

        for link in graph[departures]:
            arrivals, weight = link
                
            if distance_to_departures_from_start + weight < distance[arrivals] : # if the minimum value has to updated
  
                distance[arrivals] = distance_to_departures_from_start + weight
                heapq.heappush(q,(distance[arrivals],arrivals))
    
    return distance

a_number_of_nodes, a_number_of_links = map(int,input().split())

graph = [[] for _ in range(a_number_of_nodes + 1)] # graph initialization, node number starts from 1

start_node_number = int(input())

# Receive link input, all links are one way.
for _ in range(a_number_of_links):
    start, end, weight = map(int,input().split())

    # # Compare if there are more than two links between start and end, 
    # for link_index in range(len(graph[start])):
    #     if graph[start][link_index][0] == end and graph[start][link_index][1] > weight:
    #         graph[start][link_index] = (end,weight)
    #         continue

    graph[start].append((end,weight))

# INF means not connected 
INF = 300000*20000

distance = dijkstra(start_node_number)
for index in range(1,a_number_of_nodes + 1):

    if distance[index] != INF:
        print(distance[index])
    else:
        print("INF")