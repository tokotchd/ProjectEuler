import math

def split_pandigital(n):
    cur_num = n[-1]
    head = n
    tail = ''
    for index in range(2, len(n)+1):
        next_num = n[-index]
        if next_num <= cur_num:  # the number stopped ascending
            head = n[:-index+1]
            tail = n[-index+1:]
            break
        else:
            cur_num = next_num
    return head, tail

def get_minimum_of_but_still_greater_than(numbers, number):
    current_min = numbers[0]
    current_min_index = 0
    for index, element in enumerate(numbers):
        if element < current_min and element > number:
            current_min = element
            current_min_index = index
    return current_min, current_min_index

# in order to generate the next pandigital, we generalize every pandigital to be expressed as head, tail where tail is some *descending* number and head everything in front of it
def next_pandigital(n, pandigitals_include_zero=False):
    # the general solution is to take the tail (which is guaranteed sorted descending)
    # 689742531 -> [689742, 531]
    head, tail = split_pandigital(n)

    if len(tail) == 0:  # special case, if the entire number is descending then we need to add a digit
        digit_to_add = len(head)
        if not pandigitals_include_zero:  # if the pandigital does not include 0, then we make sure we don't add the largest element twice
            digit_to_add += 1
        head = head + str(digit_to_add)
        new_pandigital = ''.join(sorted(head))
        return new_pandigital

    # swap the last element of the head with the minimum element from the tail that is greater than it
    # [689742, 531] -> [689743, 521]
    last_head_element = head[-1]
    tail_element, tail_element_index = get_minimum_of_but_still_greater_than(tail, last_head_element)
    new_head = head[:-1] + tail_element
    new_tail = tail[:tail_element_index] + last_head_element + tail[tail_element_index+1:]

    # finally, sort the tail in ascending order
    # [689743, 521] -> [689743, 125]
    new_tail = ''.join(sorted(new_tail))
    # and stick them back together
    # [689743, 125] -> 689743125
    new_pandigital = new_head + new_tail
    return new_pandigital

def is_prime(n):
    sqrt_n = math.sqrt(n)
    for divisor in range(2, math.ceil(sqrt_n)):
        if n % divisor == 0:
            return False  # if the number is not prime, then we don't have to check any more divisors
        if divisor > sqrt_n:
            break  # we know that if we haven't found a prime number from [1, sqrt(test)] then we know there can't be a divisor in the range of [sqrt(test), test)]
    return True

def test_next_pandigital():
    test = '1'
    print(test)
    for i in range(10000):
        test = next_pandigital(test)
        print(test)

def test_is_prime():
    for test in range(2, 987654321):
        print(test, is_prime(test))

if __name__ == '__main__':
    n = '1'
    last_pandigital_prime = '1'
    while len(n) <= 9:
        n = next_pandigital(n)
        num = int(n)
        its_prime = is_prime(num)
        if its_prime:
            last_pandigital_prime = n
    print(last_pandigital_prime)