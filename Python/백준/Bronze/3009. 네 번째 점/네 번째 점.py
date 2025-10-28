rectangle1 = []
rectangle2 = []
result = []

for i in range(3):
    a, b = map(int, input().split())
    rectangle1.append(a)
    rectangle2.append(b)
    
for rect in [rectangle1, rectangle2]:
    if rect[0] == rect[1]:
        four = rect[2]
    elif rect[1] == rect[2]:
        four = rect[0]
    else:
        four = rect[1]
    result.append(four)

print(f"{result[0]} {result[1]}")