def checkVPS(sen):
    stack = []
    for i in range(len(sen)):
        if sen[i] == '(':
            stack.append(0)
        else:
            if not stack:
                return('NO')
            else:
                stack.pop()
    if not stack:
        return('YES')
    else:
        return('NO')

T = int(input())
for i in range(T):
    sen = input()
    print(checkVPS(sen))