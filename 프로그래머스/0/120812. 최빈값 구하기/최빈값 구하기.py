from collections import Counter

def solution(array):
    d = dict(Counter(array))
    dList = sorted(
        d.items(),
        key=lambda item: item[1],
        reverse=True
    )
    if len(dList) != 1 and dList[0][1] == dList[1][1]:
        return -1
    return dList[0][0]