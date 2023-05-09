# 포도주 시식
'''
https://www.acmicpc.net/problem/2156
0 1  2  3 4 5 6
0 6 10 13 9 8 1 : arr

여기부터 dp
0 6 16 / 초기값
0 6 16 max(d[3-2]+arr[3],d[3-3]+arr[3-1]+arr[3]) / 3번째 확인
0 6 16 23 max(d[4-2]+arr[4],d[4-3]+arr[4-1]+arr[4]) / 4번째 확인 
0 6 16 23 28 max(d[4-2]+arr[4],d[4-3]+arr[4-1]+arr[4]) / 5번째 확인
...
0 6 16 23 28 33 32

반례 :
6
100
400
2
1
4
200
[0, 100, 500, 402, 501, 505, 701]
701
'''
n = int(input())
arr = [0 for _ in range(n+1)]
for i in range(1,n+1):
    arr[i] = int(input())

dp = [0 for _ in range(n+1)]
dp[1] = arr[1]
if n >= 2:
    dp[2] = arr[1] + arr[2]
for j in range(3,n+1):
    dp[j] = max(dp[j-2] + arr[j], dp[j-3]+arr[j-1]+arr[j])
    dp[n] = max(dp[n-1], dp[n])

# print(dp)
print(max(dp))



