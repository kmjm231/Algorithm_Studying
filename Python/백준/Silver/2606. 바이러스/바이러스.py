# dfs
def virus(com: int, fair: int) -> int:
    visited = []

    graph = [[] for _ in range(com + 1)]
    for _ in range(fair):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    # 1 : 2 5
    # 2 : 1 3 5
    # 3 : 2
    # 5 : 1 2 6
    # 6 : 5
    # 4 : 7

    # visted = 1, 5, 6, 2, 3    -> 1 빼기
    # stack =                   -> 넣었다 뺐다

    stack = [1]  # 시작 노드
    while stack: # 스택이 비어있지 않을 때까지
        node = stack.pop()
        if node not in visited:
            for neighbor in graph[node]:
                stack.append(neighbor)
            visited.append(node)
    
    return len(visited) - 1

def main():
    com = int(input())
    fair = int(input())
    print(virus(com, fair))
    return None

if __name__ == "__main__":
    main()