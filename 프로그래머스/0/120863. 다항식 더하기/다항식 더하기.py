def solution(polynomial):
    arr = [x.strip() for x in polynomial.split('+')]
    answer = [0, 0]
    for i in arr:
        if i == 'x':
            answer[0] += 1
        elif 'x' in i:
            answer[0] += int(i[:len(i)-1])
        else:
            answer[1] += int(i)
    if answer[0] == 0 and answer[1] == 0:
        return ''
    elif answer[0] == 0 and answer[1] != 0:
        return f'{answer[1]}'
    elif answer[0] == 1 and answer[1] == 0:
        return 'x'
    elif answer[0] != 0 and answer[1] == 0:
        return f'{answer[0]}x'
    elif answer[0] == 1 and answer[1] != 0:
        return f'x + {answer[1]}'
    else:
        return f'{answer[0]}x + {answer[1]}'