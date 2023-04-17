# 단지 번호 붙이기 
'''
https://www.acmicpc.net/problem/2667
1은 집이 있는 곳
0은 집이 없는 곳 
상하좌우에 집이 있으면 연결해서 단지로 정함 
단지 수를 출력하고 
각 단지들의 집의 수를 오름차순 출력 
'''
import sys

sys.stdin = open('2667.txt')

def dfs(x,y,c):
    '''
    param
    x,y : 현재 위치 
    c : 현 단지 번호 
    '''
    global c_v
    # 집 카운트
    c_v += 1 
    # 동서남북 탐색 
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i] # 탐색할 좌표 
        # 범위안에 있고 방문 안했고 집이면 
        if 0 <= nx < N and 0 <= ny < N and visited[ny][nx] == 0 and graph[ny][nx] == '1':
            # 방문체크 
            visited[ny][nx] = c
            dfs(nx,ny,c)
    

# 지도의 row,column 수 
N = int(input()) # 5≤N≤25
# 지도 입력 받기
graph = [input() for _ in range(N)]
# 동서남북 탐색용
dx = [0,0,-1,1]
dy = [-1,1,0,0]
# 방문체크용
visited = [[0]*N for _ in range(N)]
# 단지수 카운트용
counts = 0
# 탐색 시작
rlt = []
for row in range(N):
    for col in range(N):
        if visited[row][col] == 0 and graph[row][col] == '1': # 방문 안했고 집이면 
            counts += 1 # 단지 수 추가 
            c_v = 0 # 단지 내 집의 수 카운트 용
            visited[row][col] = counts # 방문체크할 때 단지 번호 할당
            dfs(col,row,counts)
            rlt.append(c_v)

rlt.sort()
print(counts)
for s in rlt:
    print(s)