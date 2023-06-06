#시작점 S를 찾고, routes에 나온 정보에 따라 진행. 중요 포인트는, 바로 x, y를 이용하는 것이 아니라 임시 정보를 담는 a,b를 이용한다. 거리가 2인 routes를 이동할 때, 만약에 그래프 범위를 넘거나 장애물이 있으면 다시 x,y 좌표를 수정하는 것이 번거롭기 때문에 최종 조건까지 통과 되면 x = a, y = b를 통해서 저장해준다.

def solution(park, routes):
    x = 0
    y = 0
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                x = j 
                y = i
                break
    for route in routes:
        a = x #임시 정보 
        b = y
        for j in range(int(route[2])):
            if route[0] == "N" and b != 0 and park[b-1][a] != "X":  #범위 안 넘고 장애물이 아니라면
                b -= 1
                if j == int(route[2])-1:
                    y = b
            elif route[0] == "S" and b != len(park)-1 and park[b+1][a] != "X":
                    b += 1
                    if j == int(route[2])-1:
                        y = b
            elif route[0] == "W" and a != 0 and park[b][a-1] != "X":
                a -= 1
                if j == int(route[2])-1:
                    x = a
            elif route[0] == "E" and a != len(park[0])-1 and park[b][a+1] != "X":
                a += 1
                if j == int(route[2])-1:
                    x = a
                    
    return [y, x]