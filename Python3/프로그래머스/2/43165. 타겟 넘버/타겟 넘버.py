# 리스트의 각 요소마다 +, -로 두가지 경우 가능 = 이진 트리
# 모든 경우의 수를 다 해봐야 함 = 완전 탐색
## 이진 트리 완전 탐색 -> dfs로 이진 트리의 끝까지 깊이 있게 탐색

# dfs -> 재귀 함수로 구현
def dfs(index, current_sum, numbers, target):
    if index == len(numbers): # leaf 노드일때
        return 1 if current_sum == target else 0
        
    right = dfs(index + 1, current_sum + numbers[index], numbers, target) # 오른쪽 가지
    left = dfs(index + 1, current_sum - numbers[index], numbers, target) # 왼쪽 가지
    return right + left

def solution(numbers, target):
    
    answer = dfs(0, 0, numbers, target)
    
    return answer