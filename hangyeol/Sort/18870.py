# 좌표압축
'''
https://www.acmicpc.net/problem/18870
1 <= N <= 1000000
-10^9 <= X <= 10^9
-> 범위가 너무 크므로 이진탐색하자 
'''

def binary_search(target):
    '''
    이진탐색해서 target의 인덱스를 반환하는 함수
    param
    target : 찾고싶은 숫자 
    '''
    start = 0
    end = len(arr_sort)-1
    while start <= end:
        center = (start + end) // 2
        # target > center 
        if target > arr_sort[center]:
            start = center + 1
        # target < center
        elif target < arr_sort[center]:
            end = center - 1
        # target == center / 탐색성공
        else:
            return center # target의 인덱스 

# 배열의 길이 
N = int(input())

# 배열 입력받기
arr = list(map(int,input().split()))

# set으로 중복 없애고 정렬된 리스트 생성
arr_sort = sorted(set(arr))

# xi > xj 인 좌표 카운트 하기위한 리스트
rlt = [0]*N

for i in range(N):
    num = arr[i] # 현재 보는 수
    rlt[i] += binary_search(num) 
    '''
    arr_sort에서 target의 인덱스가 target보다 작은 수의 개수이므로 더해줌 

    예를 들어, 
    arr_sort = [1, 2, 3, 4] 이라고 하면 
    3의 index = 2 인데 이는 3보다 작은 수의 개수(2개)와 같다

    4의 경우에는 4의 index = 3 이고 4보다 작은 수의 개수는 3이다.

    이렇게 "해당 숫자의 인덱스 == 해당 숫자보다 작은 수의 개수" 이다
    '''

print(*rlt)  