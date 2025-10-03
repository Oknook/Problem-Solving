import math

def solution(n):
    answer = []
    for i in range(1, n+1):
        answer.append(is_prime(i))
    return sum(answer[:n+1])

def is_prime(n):
    if n <= 1:
        return False
    
    if n == 2:
        return False
        
    if n % 2 == 0:
        return True
    
    limit = int(math.sqrt(n))
    for i in range(3, limit + 1, 2):
        if n % i == 0:
            return True
            
    return False