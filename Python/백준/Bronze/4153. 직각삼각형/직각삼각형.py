while(1):
    testCase = input()
    if testCase == '0 0 0':
        break
    else:
        str_list = testCase.split()
        list = [int(x) for x in str_list] # 각 요소를 문자열 -> 정수
        # 중간값 추출
        for i in range(3):
            if min(list) < list[i] < max(list):
                median = list[i]
        if max(list)**2 == median**2 + min(list)**2:
            print('right')
        else:
            print('wrong')