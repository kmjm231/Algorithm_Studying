test = int(input())

for _ in range(test):
    number = int(input())
    
    binary = str(bin(number)[2:])[::-1]
    index = []
    
    for i in range(len(binary)):
        if binary[i] == "1":
            index.append(i)
            
    print(*index, sep=" ")