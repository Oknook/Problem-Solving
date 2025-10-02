def solution(n):
    return sum([x for x in range(1, n+1, 2)]) if n%2!=0 else sum([x**2 for x in range(2, n+1, 2)])