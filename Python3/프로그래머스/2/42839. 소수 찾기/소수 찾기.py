from itertools import permutations

# 소수 찾는 함수
def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    
    # 순열, 중복X set 사용해서 모든 조합 뽑기
    num_set = set()
    
    for i in range(1, len(numbers) + 1):
        for tup in permutations(numbers, i):
            num = "".join(tup)
            num_set.add(int(num))
    
    prime_count = 0
    for j in num_set:
        if is_prime(j):
            prime_count += 1
    
    return prime_count