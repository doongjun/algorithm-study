n = int(input())
arr = list(map(int, input().split()))
d = [1] * 1000  #해당 숫자도 포함이기 때문에 1로 시작

for i in range(1,n):
    for j in range(i):  #해당 숫자까지 for문
        if arr[i] > arr[j]: #이전 숫자보다 크면
            d[i] = max(d[i], d[j]+ 1) #dp값 +1

print(max(d))