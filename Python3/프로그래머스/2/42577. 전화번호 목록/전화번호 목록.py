def solution(phone_book):
    answer = True
    phone_set = set(phone_book)
    
    for number in phone_book:
        prefix = ""
        for ch in number[:-1]: # 자기 자신이 완성되기 전 마지막 한자리 제외
            prefix += ch
            if prefix in phone_set:
                answer = False
                return answer
            
    return answer