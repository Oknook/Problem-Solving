def solution(my_string):
    for i in range(0, 26):
        my_string = my_string.replace(chr(65+i), ' ').replace(chr(90+i), ' ')
    return sum([int(x) for x in my_string.split()])