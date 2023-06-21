#bfs돌면서 z에 중복되지 않는 알파벳들 붙여주면서 


r, c = map(int, input().split())    #그래프 행 열 길이 입력 받기
alph = [list(input()) for _ in range(r)]    #알바벳 입력 받기
dx = [-1,1,0,0] #동서남북
dy = [0,0,-1,1]

count = 1   #(0,0)도 포함시켜야 해서 1시작

def dfs():
    global count
    q = set([(0,0,alph[0][0])]) #(0,0) 그리고 (0,0)의 값으로 시작

    while q:
        x, y, z = q.pop()
        count = max(count, len(z))  #현재까지의 최댓값과 현재 알바벳 배열의 길이 비교해서 count에 넣기

        for i in range(4):  #동서남북
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < r and 0 <= ny < c and alph[nx][ny] not in z:   #그래프 안 벗어나고 전에 있던 알파벳이 아니면
                q.add((nx, ny, alph[nx][ny] + z))   #큐에 넣어주기

dfs()
print(count)