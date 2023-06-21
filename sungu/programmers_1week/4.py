def solution(wallpaper):
    answer_x = []
    answer_y = []
    answer = []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                answer_x.append(j)
                answer_y.append(i)
    answer.append(min(answer_y))
    answer.append(min(answer_x))
    answer.append(max(answer_y)+1)
    answer.append(max(answer_x)+1)
    
    return answer