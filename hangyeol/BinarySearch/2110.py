# 공유기 설치 
'''
https://www.acmicpc.net/problem/2110
이진탐색 -> 뭘 탐색할건지? -> 집 사이 거리 탐색 
공유기 설치할 거리 기준을 에초에 정해놓고 그 기준만큼 다 깔아보기 
'''

# 집의 개수 , 공유기의 개수 
N, C = map(int,input().split())
# 집 좌표 리스트 
arr = [int(input()) for _ in range(N)] 
arr.sort()

min_d = 1 # 최소 거리 
max_d = arr[-1] - arr[0] # 최대 거리 


while min_d <= max_d:
    counts = 1 # 시작점은 무조건 설치 
    # print(min_d, max_d)
    start = arr[0]
    mid_d = (min_d + max_d)//2
    # print(mid_d)
    for i in range(len(arr)):
        end = arr[i]
        distance = end - start # 집과 집 사이거리
        if distance >= mid_d: # 기준 이상이면
            counts += 1 # 공유기 설치
            start = end # 시작 비교점 갱신 
    
    if counts >= C: # 이상 나오면 간격 더 크게 해봄 
        rlt = mid_d
        min_d = mid_d + 1
    else: # 더 적으면 간격 줄임 
        max_d = mid_d - 1 

print(rlt)
