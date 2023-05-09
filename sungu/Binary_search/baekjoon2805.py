import sys
input = sys.stdin.readline

n, m = map(int, input().split())  #나무 개수, 각각의 높이 입력 받기
arr = list(map(int, input().split())) #리스트에 높이 넣기
start = 1 #절단기 높이의 최솟값
end = max(arr)  #절단기 높이의 최댓값 = 제일 높은 나무의 높이

ans = 0 #정답
while start <= end:
    mid = (start + end) // 2
    sum = 0 #잘린 나무들의 합
    for i in arr: #잘린 나무들 합 구하기
        if i > mid: #절단기보다 나무가 높다면
            sum += i - mid  #sum에 잘린 길이만큼 더하기
    if sum < m: #잘린 나무들의 합이 원하는 합 보다 작으면
        end = mid - 1 #절단기 높이를 중간값 한 칸 아래로 (더 많이 잘라야하니까)
    else:
        ans = mid
        start = mid + 1
print(ans)