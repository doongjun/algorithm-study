"""
계속 틀렸던 이유(런타임 에러, ZeroDivisionError)는 start 값을 0으로 시작했음. 0으로 시작하면 mid 값이 0이 됐을 때, 
result를 0으로 나누게 되는데, 0으로 나누는 건 불가능하기 때문에 에러가 뜸. 앞으로도 주의할 것
"""
import sys
input = sys.stdin.readline
k, n = map(int, input().split())  #랜선의 개수, 필요한 랜선의 개수 입력 받기
arr = [(int(input()))for _ in range(k)] #갖고 있는 랜선의 길이 하나씩 입력 받기
start = 1 #길이는 1부터 시작
end = max(arr)  #가장 긴 랜선을 시작 값
ans = 0
while start <= end: 
    result = 0
    mid = (start + end) // 2
    for i in arr:
        result += i // mid
    if result < n:
        end = mid - 1
    else:
        ans = mid #최댓값으로 바꾸기
        start = mid + 1
print(ans)