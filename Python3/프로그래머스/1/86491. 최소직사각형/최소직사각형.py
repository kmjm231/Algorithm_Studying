def solution(sizes):
    max_w = 0
    max_h = 0
    
    for size in sizes:
        w = max(size) # 각 명함에서 큰쪽을 w로
        h = min(size)
        
        max_w = max(max_w, w) # w중에 제일 큰
        max_h = max(max_h, h) # h중에 제일 큰
        
    return max_w * max_h