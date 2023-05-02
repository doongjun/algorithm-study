# 전화번호 목록 
'''
https://www.acmicpc.net/problem/5052
한 번호가 다른 번호의 접두어이면 안됨 
'''
def search(N):  
    '''
    아래와 같이 정렬 후 2개의 포인터를 통해 비교 
    ['113', '12340', '123440', '12345', '98346']
       ^       ^
      left   right
    
    left가 right의 접두어가 아니라면 정렬했기 때문에 그 뒤에 번호들도 볼 필요없이 다 다름
    ['113', '12340', '123440', '12345', '98346']
               ^        ^
              left     right
    두 포인터를 1씩 오른쪽으로 옮겨서 다시 비교
    이를 right이 N-1이 될때까지 반복해서 접두어가 되는 상황을 탐색하는 함수
    
    return
    접두어가 되는 상황이 있다면 'NO' 반환
    없다면 'YES' 반환

    param
    N : 전화번호 수 
    '''

    left = 0
    right = left + 1
    while right < N :
        # print(arr[left], arr[right])
        l = len(arr[left])
        if l <= len(arr[right]): #비교가능한 길이면
            if arr[left][:l] == arr[right][:l]: # 같으면 
                return 'NO'
            
        left += 1
        right += 1
    return 'YES'

# 테스트 케이스 수
t = int(input())
for _ in range(t):
    # 전화번호의 수
    n = int(input()) # 1~10000
    # 전화번호부 
    arr = list(input() for _ in range(n))
    arr.sort() # 정렬 
    # print(arr)
    if n == 1: # 전화번호가 하나 이면 무조건 YES
        print('YES')
    else:
        print(search(n))