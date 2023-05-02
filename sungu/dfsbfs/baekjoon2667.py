#visited 사용하지 않고, 방문했을 때 graph = 1을 graph = 0 으로 바꾸면서 방문처리로 품

import sys
sys.stdin = open("input.txt")
n = int(input())
graph = []
#집 개수 입력 받을 리스트
house_list = []

global house_cnt
house_cnt = 0

#지도 값 입력 받기
for i in range(n):
    graph.append(list(map(int, input())))

def dfs(x, y):
    global house_cnt
    #지도 안에 있는지 체크 
    if x <= -1 or x>=n or y <= -1 or y >= n:
        return False
    
    #집이 있으면
    if graph[x][y] == 1:
        #집 갯수 1개 추가
        house_cnt += 1
        #방문 처리
        graph[x][y] = 0 
        #해당 집 기준으로 동서남북 탐색
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        #끝나면 True 리턴
        return True
    return False

result= 0
for i in range(n):
    for j in range(n):
        #집이 있으면, 주변을 탐색하면서 단지를 만든다
        if dfs(i, j) == True:
            #단지 수 추가
            result += 1
            house_list.append(house_cnt)
            #집 개수 초기화
            house_cnt = 0
#정답 출력           
print(result)
#오름차순 정리
house_list.sort()
for i in house_list:
    print(i)
    



#첫 제출 틀린 이유: 이코테에 있는 예제에서 변형해서 푸는데, 이코테 책에서는 방문을 하면 1로 바꾸는 거고, 이 문제는 반대라 틀림
