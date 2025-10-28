first_num = int(input())
second_num = int(input())

one = second_num % 10
ten = (second_num // 10) % 10
hundred = second_num // 100

print(first_num * one)
print(first_num * ten)
print(first_num * hundred)
print(
    first_num * one + first_num * ten * 10 + first_num * hundred * 100
)