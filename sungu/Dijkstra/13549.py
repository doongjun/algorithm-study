#도저히 혼자 못풀겠음. 다른 사람 코드 보고 품.


import sys
import heapq
input = sys.stdin.readline
a, b = map(int, input().split())  #수빈, 동생 값 입력 받기
inf = sys.maxsize #최대정수

def dijkstra(a, b): 
    dist = [inf] * (100001) #위치 그래프 만들기
    dist[a] = 0 #수빈의 현재 위치까지 시간 0
    q = []  #큐 생성
    heapq.heappush(q, (0, a)) #큐 초기값 (수빈이 위치 데이터 넣기)
    while q:
        time, location = heapq.heappop(q) #큐에서 최솟값 pop
        for nx in [(location+1, 1), (location-1, 1), (location*2, 0)]:  #뒤, 앞, 순간이동
          if 0 <= nx[0] <= 100000 and dist[nx[0]] > time + nx[1]: #범위를 넘어가지 않고 기존 시간보다 적게 걸렸으면
            dist[nx[0]] = time + nx[1]  #새로운 값으로 바꿈
            heapq.heappush(q,(dist[nx[0]],nx[0])) #다시 새로운 값 큐에 넣기
    print(dist[b])
dijkstra(a, b)