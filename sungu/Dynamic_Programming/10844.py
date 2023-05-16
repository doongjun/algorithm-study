#혼자 해결하지 못하고 아이디어 참고 한 문제,,

n = int(input())
dp = [[0 for i in range(10)] for j in range(101)]
for i in range(1, 10):
    dp[1][i] = 1  #1자리 수들은 1개씩이라서 고정
for i in range(2, n+1): #2자리 수부터 시작
    for j in range(10):
        if j == 0:  #0으로 끝나는 수는 앞 dp 1밖에 안 됨  
            dp[i][j] = dp[i-1][1]
        elif j == 9:  #9로 끝나는 수는 앞 dp 8 밖에 안 됨
            dp[i][j] = dp[i-1][8]
        else: #나머지는 전 dp -1, +1 하나씩 가능 (총 2개)
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
print(sum(dp[n])%1000000000)
