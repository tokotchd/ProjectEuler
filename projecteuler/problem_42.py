def get_word_value(word):  # ord returns word values 65 (A) through 90 (Z) for
    word_total = 0
    for char in word:
        char_value = ord(char) - 64
        word_total += char_value
    return word_total

def get_triangle_number(n):  # returns the nth triangle number
    return 0.5 * n * (n+1)

if __name__ == '__main__':
    with open('./p042_words.txt') as text_file:
        massive_line = text_file.readline()  # this gets us the single line of the text file
        words = massive_line.split(',')  # this gets us all of the words in a list
        words = [word.split('"')[1] for word in words]  # this gets rid of all of the surrounding quotes of words
        all_triangle_numbers = [1]
        num_triangle_words = 0
        for word in words:
            word_value = get_word_value(word)
            # three cases exist: word < last_triangle_number, word == last_triangle_number, and word > last_triangle_number
            while word_value > all_triangle_numbers[-1]:  # if current word value is greater than our largest triangle number, we have to generate more triangle numbers until it isn't
                all_triangle_numbers.append(get_triangle_number(len(all_triangle_numbers) + 1))
            # after we've guaranteed that word value <= the last triangle number, we can search through the triangle numbers to see if it is one
            if word_value in all_triangle_numbers:
                num_triangle_words += 1
    print(num_triangle_words)