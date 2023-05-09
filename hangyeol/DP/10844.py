# 쉬운 계단 수 
'''
https://www.acmicpc.net/problem/10844
   | 0 1 2 3 4 5 6 7 8 9
 1 | 0 1 1 1 1 1 1 1 1 1
      X X X X X X X X X
 2 | 1 1 2 2 2 2 2 2 2 1

 끝이 0과 9인건 한 개의 숫자밖에 못만들어낸다 
 끝이 1 ~ 8이라면 다음자리 숫자가 +1 -1인 계단 수를 만들어냄 

 위처럼  끝이 1인 숫자는 이전 끝자리가 0과 2인 수에서 부터 나오고 
 끝이 7이면 이전 끝자리가 6과 8인 수로부터 나오므로 
 길이가 length이고 n으로 끝나는 계단수의 수는 
 길이가 (length - 1)이고 (n-1)로 끝나는 계단 수의 수와 (n+1)로 끝나는 계단 수의 수를 
 더해주면 된다 
'''

N = int(input()) # 계단수의 길이 

d = [[0 for _ in range(10)] for _ in range(N+1)] # 계단수의 길이를 담을 2차원 리스트 (행: 계단수의 길이 / 열: 1의 자리의 숫자) 
# N = 1일 때 초기값 입력 
for i in range(1,10): # 0으로 시작하는 자연수는 없으므로 0은 0개임 
    d[1][i] += 1

for length in range(2,N+1): # 길이가 2인 것부터 기록 
    for number_of_end in range(10): # 1의 자리의 숫자
        if 0 < number_of_end < 9 :
            d[length][number_of_end] = d[length-1][number_of_end-1] + d[length-1][number_of_end+1] 

        elif number_of_end == 0 :
            d[length][number_of_end] = d[length-1][number_of_end+1]

        elif number_of_end == 9 :
            d[length][number_of_end] = d[length-1][number_of_end-1]

print(sum(d[N]) % 1000000000) # 결과 출력

