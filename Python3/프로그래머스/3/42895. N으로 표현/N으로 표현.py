## DP 문제 판별법
# 점화식 만들 수 있는가
# 피보나치 같이 반복되는 풀이
# 문제에 "최대, 최소, 가능한가?, 경우의 수..." => 최적화를 묻는지


def solution(N, number):
    if N == number:
        return 1

    # dp[k] : N을 k번 사용할 때 나올 수 있는 사칙연산 조합
    dp = [set() for _ in range(9)] # 최솟값이 8보다 크면 -1이므로 8까지만 구함

    for k in range(1, 9): # 1~8
        dp[k].add(int(str(N)*k)) # 5, 55, 555는 미리 넣어둠

        for i in range(1, k): # dp[5] = dp[1] +,-,*,// dp[4]
            for a in dp[i]:
                for b in dp[k-i]:
                    dp[k].add(a + b)
                    dp[k].add(a - b)
                    dp[k].add(a * b)
                    if b != 0:
                        dp[k].add(a // b)
        
        # 작은 숫자부터 for문 돌리니까 방금 구한 값에 타겟 넘버가 있었다면 구한 것.
        if number in dp[k]:
            return k

    # 8을 넘어가면 -1
    return -1