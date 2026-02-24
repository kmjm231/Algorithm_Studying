def solution(n, lost, reserve):
    lost = set(lost)
    reserve = set(reserve)

    # lost & reserve 겹치는 학생 제거
    intersect = lost & reserve
    lost -= intersect
    reserve -= intersect
    
    for i in sorted(reserve):
        if i - 1 in lost:
            lost.remove(i-1)
        elif i + 1 in lost:
            lost.remove(i+1)
    
    return n - len(lost)