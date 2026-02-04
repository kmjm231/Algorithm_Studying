def solution(array, commands):
    answer = []
    
    for command in commands:
        # 슬라이싱
        new_array = array[command[0] - 1:command[1]]
        
        # 정렬
        for i in range(len(new_array)):
            sm_ind = i
            for j in range(i+1, len(new_array)):
                if new_array[j] < new_array[sm_ind]:
                    sm_ind = j
            new_array[i], new_array[sm_ind] = new_array[sm_ind], new_array[i]
    
        answer.append(new_array[command[2]-1])
    return answer