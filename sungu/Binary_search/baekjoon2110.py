#거리를 기준으로 이분탐색 할 생각을 못해서 계속 고민하다 다른 사람들꺼 보고 힌트 얻고 다시 품
#집 좌표에 mid를 계속 더해주면서 끝 집 좌표를 넘는지 안 넘는지 비교해가며 이분탐색

import sys
input = sys.stdin.readline

n, c = map(int, input().split())  #집의 개수, 공유기 개수 입력 받기
arr = [(int(input())) for _ in range(n)]  #집 위치 입력 받기
arr.sort()  #정렬
min, max = 1, arr[-1] - arr[0]  #첫 집과 마지막 집을 min, max
ans = 0 #정답

while min <= max:
    mid = (max + min) // 2
    cnt = 1
    cur = arr[0]  #첫번째 집

    for i in range(1, len(arr)):
        if arr[i] >= cur + mid: 
            cur = arr[i]
            cnt += 1

    if cnt >= c:
            min = mid + 1
            ans = mid
    else:
            max = mid - 1
print(ans)