import sys
input = sys.stdin.readline

T = int(input())  #테스트케이스 수 입력받기
for _ in range(T):
    n = int(input())  #전화번호 수 입력받기
    num = [input().strip() for _ in range(n)] #전화번호 입력받기
    num.sort()  #전화번호 오름차순 정렬
    no_same = True  #겹치는 거 없으면 True
    for i in range(1,n):
        if num[i].startswith(num[i-1]): #i번째 숫자가 i-1번째 숫자로 시작하면
          no_same = False #True --> False
          break #종료
    if no_same:
      print("YES")
    else:
      print("NO")