def solution(priorities, location):
    visited = [False] * len(priorities)
    number = 0
    
    while number < len(priorities):
        for i in range(len(priorities)):
            if not visited[i]:
                not_big = False
                visited[i] = True

                for j in range(len(priorities)):
                    if priorities[j] > priorities[i] and not visited[j]:
                        visited[i] = False
                        not_big = True
                        break
                
                if not not_big:
                    number += 1
                    if i == location:
                        return number
        
