n = int(input())  

number = list(map(int, input().split()))  #숫자 입력받기

set_num = sorted(list(set(number))) #입력 받은 숫자, 중복 제거 -> 리스트에 담고 -> 오름차순 정렬

dic = {set_num[i] : i for i in range(len(set_num))} #set_num에 있는 숫자를 key값, i에 value 짝지어주기

for i in number:
    print(dic[i], end=" ")  #number에 들어있는 숫자들 하나씩 꺼내서 dic에서 찾고, 각 value값 print