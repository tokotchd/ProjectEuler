'''
0-9 digits are 0-9 numbers
10th digit is 1
11th digit is 0
12th digit is 1
13th digit is 1
14th digit is 1
15th digit is 2

1 -> 1
10 -> 10
100 ->

'''

masterString = '.'
for i in range(1,10**6):
    masterString = masterString + str(i)
product = 1
for i in range(7):
    product = product * int(masterString[10**i])
print(product)
