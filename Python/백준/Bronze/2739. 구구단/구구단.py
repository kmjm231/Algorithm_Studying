import sys
input = sys.stdin.readline()

number = int(input)

for i in range(1, 10):
    print(number, "*", i, "=", number*i)