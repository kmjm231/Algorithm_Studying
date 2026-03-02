from collections import deque

def solution(n, computers):
    visited = [False] * n
    networks = 0
    
    def bfs(start):
        queue = deque([start])
        visited[start] = True
        
        while queue:
            node = queue.popleft()
            for nxt in range(n):
                if computers[node][nxt] and not visited[nxt]:
                    queue.append(nxt)
                    visited[nxt] = True
        
    for i in range(n):
        if not visited[i]:
            bfs(i)
            networks += 1
                
    return networks