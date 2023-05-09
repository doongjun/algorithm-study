#계속 에러났던 이유 -> 18번째 줄에서 dp[i-3]의 값을 구해야하는데 초기 세팅할 때 리스트 0번째 값부터 시작하면 에러가 난다.


n = int(input())
arr = [0]
for _ in range(n):
    arr.append(int(input()))

dp = [0] * (n+1)
dp[1] = arr[1]

if n >= 2:
    dp[2] = arr[1] + arr[2]

for i in range(3, n+1):
    case1 = dp[i-1] #해당번째 포도주 안 마시기
    case2 = arr[i] + dp[i-2]  #전번째 포도주 안 마시기
    case3 = arr[i] + arr[i-1] + dp[i-3] #전전번째 포도주 안 마시기

    dp[i] = max(case1, case2, case3)  #위 3가지 경우들 중 최댓값

print(dp[n])  #출력