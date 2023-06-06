'''
나동빈 최단경로 예제2

every_distance_of_node_to_node = 1
start_location = 1

He have to go X from start_location.

And he have to visit K before arrive X.

He want to find the fastest way.

In short, we have to find the fastst way 1 -> K -> X.
'''
# for checking time of program
# import math
# import time

# input
import sys 
sys.stdin = open('future_city_input.txt')
input = sys.stdin.readline

# I'll use heapq. because it is the fastest way to take out the smallest value to arrivals from departure.
import heapq

def dijkstra(start,end):
    global flag
    # distance initialization
    inf = 10001
    distance = [inf for _ in range(a_number_of_nodes + 1)]
    
    q = [] # heapq initialization
    distance[start] = 0
    heapq.heappush(q, (0,start))

    while q:
        # take out node that has the smallest distance to node from start
        distance_to_departure_from_start ,departures = heapq.heappop(q)
        for arrivals in graph[departures]:
            if distance_to_departure_from_start + 1 < distance[arrivals]: # if the minimum value has to updated
                distance[arrivals] = distance_to_departure_from_start + 1
                heapq.heappush(q, (distance[arrivals],arrivals))
    
    if distance[end] != inf:
        flag = True
    return distance[end]

for tc in range(2):
    # start = time.time()

    a_number_of_nodes, a_number_of_links = map(int,input().split())

    # make graph of links
    graph = [[] for _ in range(a_number_of_nodes + 1)]
    for _ in range(a_number_of_links):
        node1, node2 = map(int,input().split())
        graph[node1].append(node2)
        graph[node2].append(node1)

    final_arrivals, first_arrivals = map(int,input().split())

    flag = False
    rlt = dijkstra(1,first_arrivals) + dijkstra(first_arrivals,final_arrivals)

    # end = time.time()

    if flag:
        print(rlt)

    else:
        print(-1)

    # print(f"{end - start:.5f} sec")