def fibonacci(n):
    memo = []
    for i in range(n + 1): # 2차원 배열 초기화
        memo.append([0, 0])
        
    memo[0] = [1, 0]
    
    if n >= 1:
        memo[1] = [0, 1]
        if n > 1:
            for i in range(2, n+1):
                memo[i][0] = memo[i-2][0] + memo[i-1][0]
                memo[i][1] = memo[i-2][1] + memo[i-1][1]
    return memo[n]

T = int(input())
for _ in range(T):
    n = int(input())
    result = fibonacci(n)
    print(result[0], result[1])