def solution(a, b, c):
    return {3:a+b+c, 2:(a+b+c)*(a**2+b**2+c**2), 1:(a+b+c)*(a**2+b**2+c**2)*(a**3+b**3+c**3)}[len(set([a,b,c]))]