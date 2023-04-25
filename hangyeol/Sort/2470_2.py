# 두 용액 
'''
https://www.acmicpc.net/problem/2470
'''

def two_pointer(N):
    '''
    투 포인터를 이용해 용액들의 합의 절대값 중에 자장 작은 값을 구하는 함수 

    예를 들어, 
    [-3, -2, -1, 0 ,1 ,4, 6] 으로 정렬된 용액 리스트가 있다하면 
    left 포인터는 index = 0 에서 시작 / right 포인터는 index = N-1 에서 시작 
    두 용액의 합의 산성도가 -3 + 6 = 3 으로 양수면 
    왼쪽 용액의 절대값보다 오른쪽 용액의 절대값이 더 큰 것임 
    근데 왼쪽의 포인터를 오른쪽으로 옮기면 -2 + 6 = 4 로 차이가 더 커진다 
    따라서, 절대 값이 더 큰 용액을 작은 쪽으로 옮기면 -3 + 4 = 1 로 더 작아지기 때문에 
    두 용액의 합이 양수면 절대 값이 더 큰 오른쪽 포인터를 작은 쪽으로 옮겨보고 
    합이 음수면 절대 값이 더 큰 왼쪽 포인터를 작은 쪽으로 옮겨보면서 
    합의 절대 값이 더 작은 것을 찾아간다 

    param
    N : 용액의 개수
    '''
    left = 0 # 첫 인덱스
    right = N-1 # 마지막 인덱스
    rlt = [2000000001, -2,-2] # 섞은 후 산성도의 절대값, 산성도 작은 용액, 산성도 큰 용액을 담은 리스트의 초기값
    while left < right : # 왼쪽 pointer가 오른쪽 pointer보다 왼쪽에 있을 때까지 
        now = arr[left] + arr[right] # (두 용액 섞은) 새로운 용액의 산성도 
        abs_now = abs(now)  # 새로운 용액의 산성도의 절대값
        # 최솟값과 비교 
        if rlt[0] > abs_now : # 현재까지의 최소값보다 작으면 
            rlt[0] = abs_now # 새로운 용액의 산성도 최소값 할당 
            rlt[1] = arr[left] # 왼쪽 용액 할당
            rlt[2] = arr[right] # 오른쪽 용액 할당

        if now > 0: # 합이 양수면 
            right -= 1 # 오른쪽 포인터를 왼쪽으로 하나 옮김 
    
        elif now < 0: # 합이 음수면  
            left += 1 # 왼쪽 포인터를 오른쪽으로 하나 옮김
    
        else: # 0 이면 
            print(arr[left],arr[right]) # 왼용액 오른용액 출력하고
            return # 종료 
        
    print(*rlt[1:]) # 최소값으로 기록된 용액들 출력 

N = int(input()) # 용액의 수
arr = list(map(int,input().split())) # 용액들의 산성도 
arr.sort()
two_pointer(N)