def solution(array, commands):
    answer = []
    
    for i, j, k in commands:
        # 1. 슬라이싱하기
        new_array = array[i-1:j]
        # 2. 정렬하기
        new_array = sorted(new_array)
        target = new_array[k-1]
        
        answer.append(target)

    return answer