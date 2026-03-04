def solution(brown, yellow):

    find = False
    a = 0
    b = 0
    
    # yellow를 곱으로 분해한 여러 조합. -> A x B
    for i in range(1, int(yellow**0.5) + 1): # 1부터 (yellow/2)-1까지 두 곱으로 표현되는지 찾기
        if yellow % i == 0: # 나머지 없이 나뉘어진다면
            a = i + 2
            b = yellow // i + 2
            # Ax2 + Bx2 + 4 == brown이라면 A, B 찾기 완료
            if (a * b) - yellow == brown:
                if a > b:
                    return [a, b]
                return [b, a]
            

