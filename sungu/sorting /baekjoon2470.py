
import sys
input = sys.stdin.readline
n = int(input())  #숫자 개수 입력 받기

s = list(map(int, input().split())) #숫자들 입력 받기
s.sort() #오름차순 정렬

L, R = 0, n-1   #현 위치
ans_L, ans_R = L, R #최종 위치

result = abs(s[L] + s[R]) #현재 두 숫자 합의 절대값
while L < R:  
    sum = s[L] + s[R] #현재 두 숫자의 합

    if abs(sum) < result: #두 숫자 합의 절대값이 기존 보다 작다면
        ans_L, ans_R = L, R #최종위치를 현재 위치로 바꾸기
        result = abs(sum) #현 위치의 두 값으로 바꾸기

        if result == 0: #합이 0이면 최소값이기 때문에 정답
            break
        
    if sum < 0: #둘의 합이 0보다 작으면 
        L += 1 #왼쪽 현위치 한 칸 오른쪽으로
    else:
        R -= 1  #한 칸 왼쪽으로

print(s[ans_L], s[ans_R])