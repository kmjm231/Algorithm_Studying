from collections import deque

def is_one_diff(first, second):
    diff = 0
    for i in range(len(first)):
        if first[i] != second[i]:
            diff += 1
        if diff > 1:
            return False
    return diff == 1

def solution(begin, target, words):
    changed = [False] * len(words)
    
    if target not in words:
        return 0

    queue = deque([(begin, 0)])
    
    while queue:
        word, cnt = queue.popleft()
        # 지금 꺼낸게 타겟이면 최소로 변환된 단어 -> 종료
        if word == target:
            return cnt
        
        for i in range(len(words)):
            candidate = words[i]
            
            # 방금 꺼낸 단어랑 한글자만 다르다면 큐에 넣는다
            if is_one_diff(word, candidate) and not changed[i]:
                queue.append((candidate, cnt+1))
                changed[i] = True
                
    return 0