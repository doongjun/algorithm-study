
import sys
input = sys.stdin.readline

T = int(input())  #테스트케이스 개수 입력받기

for _ in range(T):  #테스트케이스 개수 만큼 반복
    n = int(input())  #인원수 입력받기
    score = []  #신입사원 점수 넣을 리스트
    ans = 1   #서류가 1등인 인원을 기준으로 시작하기 때문에, 그 사람은 무조건 합격이니까 1에서 시작

    for _ in range(n):
        score.append(list(map(int, input().split()))) #점수 입력 받기


    score = sorted(score) #서류 점수 순으로 오름차순 정렬
    cur = score[0][1] #서류 점수 1등인 사람의 면접 점수

    for i in range(1, n): #서류 2등인 사람부터 면접 점수 비교
        if cur > score[i][1]: 
            cur = score[i][1]
            ans += 1

    print(ans)