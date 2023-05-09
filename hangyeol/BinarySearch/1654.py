# 랜선 자르기 

'''
https://www.acmicpc.net/problem/1654
랜선을 모두 자를 필요 없음 스바
100 800 의 랜선 2개가 있을 때 
2개의 랜선을 만들어야 하면 
100 2개가 아니라
400으로 잘라서
400 2개를 만들면 400이 최대 길이가 된다 
'''

K, N = map(int,input().split()) # 갖고있는 랜선의 개수, 필요한 랜선의 개수

arr = [int(input()) for _ in range(K)] # 갖고있는 랜선의 길이 리스트 

max_len = max(arr) # 최대 랜선의 길이 초기값, 이미 갖고 있는 렌선 중 길이가 가장 긴 랜선의 길이보다 길게 자를 수 없음
min_len = 1
while min_len <= max_len:
    # print(min_len, max_len)
    mid_len = (max_len+min_len)//2
    # print(mid_len)
    counts = 0
    for len in arr:
        counts += len//mid_len

    if counts >= N: # 더 많이 나오면 더 길게 잘라봐도 됨 
        min_len = mid_len + 1
    elif counts < N: # 더 적게 나오면 더 짧게 잘라야함 
        max_len = mid_len - 1

print(max_len)