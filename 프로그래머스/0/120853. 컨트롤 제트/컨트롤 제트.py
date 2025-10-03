def solution(s):
    answer = s.split()
    for i in range(len(answer)):
        if answer[i] == "Z":
            answer[i-1] = 0
            answer[i] = 0
    return sum(map(int, answer))