# 나무 자르기 
'''
https://www.acmicpc.net/problem/2805
이 문제도 마찬가지로 나무를 모두 자를 필요 없다 
+  적어도 M미터의 나무를 집에 가져가기 위해서 -> 정확히 M이 되는 경우가 없을 수 있다
'''
def bianry_search():
    max_H = arr[-1]
    min_H = 0
    
    while min_H <= max_H:
        H = (min_H + max_H) // 2
        # print('현재높이', H)
        length = 0
        for i in range(N-1,-1,-1): # 나무 큰거부터 자르기 
            tree = arr[i]
    
            if tree <= H: # 정렬된 상태로 자르고 있으니까 현재 H 이하의 나무들 이후의 나무들은 모두 H 이하이므로 반복문 종료 
                break
    
            length += tree - H
        # print(length)
        if length >= M: # 길이가 더 많이 나왔으면 H더 높여봐도 됨 
            min_H = H + 1
        elif length < M: # 길이가 부족하면 높이 더 내려봐야함
            max_H = H - 1
        # else:
        #     print(H)
        #     return
    print(max_H)

N, M = map(int,input().split()) # 나무의 수, 집으로 가져가려는 나무의 길이 M

arr = list(map(int,input().split())) # 나무 길이 리스트
arr.sort() # 정렬 

bianry_search()