def solution(myString, pat):
    return int(pat.replace('B', 'C').replace('A', 'B') in myString.replace('A', 'C'))