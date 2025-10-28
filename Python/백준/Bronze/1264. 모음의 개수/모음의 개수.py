vowels = ["a", "e", "i", "o", "u"]

while True:
    sentense = input()
    
    if sentense == "#":
        break
    count = 0
    for i in sentense.lower():
        if i in vowels:
            count += 1
    print(count)