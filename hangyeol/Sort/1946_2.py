# 신입 사원 

'''
https://www.acmicpc.net/problem/1946
적어도 하나가 다른 지원자보다 등수가 낮으면 안됨
'''

T = int(input())
for tc in range(T):
    N = int(input())
    arr = [0]*(N+1) # index : 서류등수 / 원소 : 면접등수
    for _ in range(N):
        a, b = map(int,input().split()) # 서류 등수, 면접 등수  
        arr[a] = b
    # print(arr)
    counts = 1 # 서류성적이 1등인 사람은 카운트하고 시작
    for index in range(2,N+1): # 2등부터 비교
        if arr[index-1] > arr[index]: # 면접등수(arr[index])가 arr[index - 1] 높으면
            '''
            index는 해당 지원자의 서류 등수이고
            arr[index]는 해당 지원자의 면접 등수이다

            이미 서류 등수가 (index)인 지원자는 이미
            서류 등수가 (index - 1)인 지원자보다 서류 등수가 낮은 상태이므로 
            면접 등수(arr[index])가 arr[index - 1] 보다 높아야 
            적어도 하나가 다른 지원자보다 등수가 낮지 않은 것이므로
            합격자로 카운트한다
            '''
            counts += 1
        else:
            arr[index] = arr[index-1]
            '''
            카운트 안된 사람과 비교하면 안되므로 
            카운트 안된 사람의 바로 앞 사람의 성적과 비교하기 위해 
            임의로 앞사람의 성적을 카운트 안됨 사람의 성적에 넣어줘야
            동일한 if문을 사용할 수 있다 
            '''
    print(counts)