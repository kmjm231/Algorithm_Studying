### 다시 풀어보기
# bfs + 거리 기억하면서 최단 거리 찾는 문제

from collections import deque

def solution(maps):
    col, row = len(maps), len(maps[0])
    visited = [[False] * row for _ in range(col)]

    def bfs():
        queue = deque([(0, 0, 1)])
        visited[0][0] = True
        
        while queue:
            x, y, dist = queue.popleft()
            
            # 목표 도착
            if x == col-1 and y == row-1:
                return dist
            
            for nx, ny in [(x+1, y), (x-1, y), (x, y+1), (x, y-1)]:
                if 0 <= nx < col and 0 <= ny < row:
                    if maps[nx][ny] == 1 and not visited[nx][ny]:
                        visited[nx][ny] = True
                        queue.append((nx, ny, dist+1))
                        
        # while 다 돌고 모든 1을 탐색했는데 목적지에 도달을 못했다 -> 도달 불가능
        return -1
    
    return bfs()