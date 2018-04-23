# a^2 + b^2 = c ^2 #Pythagorean Theorem
# a + b + c = p # Defintion of Perimeter
# a + b >= c Triangle Inequality
# b >= a Custom parameter for QOL.


# chose a p for a loop
# any given p will have a range of integer a's and b's
# so we iterate through all a's from 1 to ceil(p/3)
# then we iterate through all b's from a to ciel(p/3)
# c is defined by sqrt(a^2 + b^2)
# if c is non integer, we can stop
# if c is integer, we continue:
# if a + b + c is p, we call it good, else it is not.
import math

maxPCount = 0
maxP = 0
for p in range(1000):
    thisPCount = 0
    for a in range(1, p//3):
        for b in range(a,p//2):
            c = (a**2 + b **2)**0.5
            if math.ceil(c) == c and a + b + c == p:
                thisPCount = thisPCount + 1
    #print(p, thisPCount)
    if thisPCount > maxPCount:
        maxP = p
        maxPCount = thisPCount
print(maxP, maxPCount)
