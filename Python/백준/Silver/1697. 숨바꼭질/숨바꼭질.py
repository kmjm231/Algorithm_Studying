from collections import deque

def find(N: int, K: int) -> int:
    MAX = 100001
    deq = deque([N])
    visited = [-1] * MAX
    visited[N] = 0

    while deq:
        x = deq.popleft()
        if x == K:
            return visited[x]
        for i in [x - 1, x + 1, 2 * x]:
            if 0 <= i < MAX and visited[i] == -1:
                visited[i] = visited[x] + 1
                deq.append(i)

N, K = map(int, input().split())
print(find(N, K))