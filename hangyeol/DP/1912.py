# 연속합 
'''
https://www.acmicpc.net/problem/1912
연속된 N개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합 구하기 
'''
import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int,input().split()))
d = [0 for _ in range(N)] # 각 인덱스까지 더했을 때 1~n개 연속 더한거 중 최댓값 넣기
d[0] = arr[0]

for end_index in range(1,N):
    if d[end_index - 1] + arr[end_index] > arr[end_index]: # 이전까지의 최대값 + 현재 값이 그냥 현재값보다 크면
        d[end_index] = d[end_index - 1] + arr[end_index]
        '''
        d[end_index - 1] + arr[end_index] 
        이전까지의 최대값 + 현재 값
        '''
    else:
        d[end_index] = arr[end_index] # 그냥 값이 더 크면 그냥 할당 

print(max(d))