import sys
from collections import deque

# sys.stdin.readline을 input으로 사용
input = sys.stdin.readline

# 1. 입력 및 초기화
try:
    # N (행), M (열) 크기 입력
    # .split()만 사용하여 map()에 전달
    N, M = map(int, input().split()) 
except:
    sys.exit()

campus = []
start_r, start_c = -1, -1

# N개의 줄에 걸쳐 캠퍼스 정보 입력받기
for r in range(N):
    # 한 줄을 읽고 양쪽 공백(개행 문자 포함)을 제거
    line_str = input().strip()
    
    # 입력이 부족한 경우 대비 (N줄이 다 안 들어왔을 때)
    if not line_str: 
        break
    
    row = list(line_str)
    campus.append(row)
    
    # 도연이(I)의 시작 위치 찾기
    for c in range(M):
        if row[c] == 'I':
            start_r, start_c = r, c
            break

# 2. BFS 탐색 함수
def bfs(start_r, start_c, N, M, graph):
    # 상하좌우 이동 방향 정의 (dr: 행 변화, dc: 열 변화)
    dr = [0, 0, 1, -1] 
    dc = [1, -1, 0, 0] 
    
    # 큐 초기화 (시작점: (r, c))
    queue = deque([(start_r, start_c)])
    
    # 방문 배열 초기화 (N x M 크기)
    visited = [[False] * M for _ in range(N)]
    visited[start_r][start_c] = True
    
    person_count = 0
    
    while queue:
        r, c = queue.popleft() # 현재 위치 (행, 열)
        
        # 4방향 탐색
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            
            # 1. 캠퍼스 범위 체크
            if 0 <= nr < N and 0 <= nc < M:
                
                # 2. 방문 여부 체크
                if not visited[nr][nc]:
                    
                    # 3. 벽('X')이 아닌지 체크
                    if graph[nr][nc] != 'X':
                        
                        # 방문 처리
                        visited[nr][nc] = True
                        
                        # 4. 사람('P') 카운트
                        if graph[nr][nc] == 'P':
                            person_count += 1
                            
                        # 5. 다음 탐색을 위해 큐에 추가 (벽만 아니면 이동 가능)
                        queue.append((nr, nc))
                        
    return person_count

# 3. 실행 및 출력
if start_r != -1:
    # BFS 함수 호출 시 N, M 크기 정보도 명시적으로 전달
    result = bfs(start_r, start_c, N, M, campus)
    
    # 요구사항 반영: 만난 사람이 0명이면 "TT" 출력
    if result == 0:
        print("TT")
    # 만난 사람이 있다면 그 수를 출력
    else:
        print(result)