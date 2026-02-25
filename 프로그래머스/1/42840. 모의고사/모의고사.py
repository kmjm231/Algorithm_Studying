def solution(answers):
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    
    scores = [0,0,0]
    
    for i, a in enumerate(answers):
        if a == one[i % len(one)]:
            scores[0] += 1
        if a == two[i % len(two)]:
            scores[1] += 1
        if a == three[i % len(three)]:
            scores[2] += 1
    
    max_score = max(scores)
    return [i+1 for i, s in enumerate(scores) if s == max_score]