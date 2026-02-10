import math

def solution(progresses, speeds):
    days = [
        math.ceil((100 - p) / s) # 올림함수 1.25일 -> 2일로
        for p, s in zip(progresses, speeds)
    ]
    
    current = days[0]
    cnt = 1
    answer = []
    
    for d in days[1:]:
        if d <= current:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            current = d
    
    answer.append(cnt)
    
    return answer