def solution(triangle):
    
    for i in range(len(triangle) - 2, -1, -1): # 3 - 2 - 1 - 0으로 돌아감
        for j in range(len(triangle[i])): # 3단일때 2, 7, 4, 4로 돌아감
            triangle[i][j] += max(
                triangle[i+1][j], triangle[i+1][j+1] # 아래칸 두개 중 큰 값을 더해서 누적합으로 값을 바꿈
            )
    
    return triangle[0][0]