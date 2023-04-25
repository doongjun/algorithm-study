#가지치기 형태, +1 -1 *2를 하나씩 하면서 확장해나가면서 1초씩 추가하고, 동생을 만났을 때 값을 리턴 받음

from collections import deque
import sys
input=sys.stdin.readline

def bfs(start, end):
    q = deque()
    q.append(start)
    visited = [0]*(max+1)

    while q:
        cur = q.popleft()
        if cur == end:    #동생 찾으면
            return visited[cur]   #값 리턴

        for i in (cur+1,cur-1,cur*2):
            if 0 <= i <= max and visited[i] == 0:
              q.append(i) #1초 추가
          
              visited[i] = visited[cur] + 1



max = 100000 

#1
a, b = map(int, input().split())    #형, 동생 값 입력 받음

print(bfs(a, b))