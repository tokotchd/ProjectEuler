from problem_41 import next_pandigital

# test to see if this works for pandigital numbers containing 0, as it wasn't originally designed for that.
# after testing it looks like it will work for pandigitals containing 0 so long as it doesn't need to add digits.
def test_next_pandigital():
    test = '0'
    print(test)
    for i in range(100):
        test = next_pandigital(test, True)
        print(test)

def is_pandigital_weird(n):
    if not int(n[1:4]) % 2 == 0:
        return False
    if not int(n[2:5]) % 3 == 0:
        return False
    if not int(n[3:6]) % 5 == 0:
        return False
    if not int(n[4:7]) % 7 == 0:
        return False
    if not int(n[5:8]) % 11 == 0:
        return False
    if not int(n[6:9]) % 13 == 0:
        return False
    if not int(n[7:10]) % 17 == 0:
        return False
    return True

def test_is_pandigital_weird():
    print(is_pandigital_weird('1406357289'))

if __name__ == '__main__':
    this_pandigital = '0123456789'
    pandigitals_total = 0
    while True:
        if this_pandigital == '9876543210':
            print(pandigitals_total)
            exit()
        is_this_pandigital_weird = is_pandigital_weird(this_pandigital)
        if(is_this_pandigital_weird):
            pandigitals_total += int(this_pandigital)
        this_pandigital = next_pandigital(this_pandigital, True)
