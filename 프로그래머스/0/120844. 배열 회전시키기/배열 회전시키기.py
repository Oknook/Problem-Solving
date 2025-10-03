from collections import deque

def solution(numbers, direction):
    q = deque(numbers)
    q.appendleft(q.pop()) if direction == "right" else q.append(q.popleft())
    return list(q)