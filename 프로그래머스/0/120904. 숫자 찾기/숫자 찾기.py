def solution(num, k):
    return [int(x) for x in str(num)].index(k)+1 if k in [int(x) for x in str(num)] else -1