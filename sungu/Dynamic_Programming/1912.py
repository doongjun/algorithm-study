n = int(input())
arr = list(map(int, input().split()))
dp = [0] * n  #dp 생성

dp[0] = arr[0]  #첫번째 값 입력
for i in range(1, n):
    if dp[i-1] > 0: #이전까지의 수들의 합이 양수면, 더했을 때 무조건 더 커지기 때문에 
        dp[i] = arr[i] + dp[i-1]  #현재 dp 값은 (현재 수 + 전까지 수들의 합)
    else: #음수면 더했을 때 무조건 작아지기 때문에 
        dp[i] = arr[i]  #현재 dp 값을 그냥 현재 수로 넣음
print(max(dp))