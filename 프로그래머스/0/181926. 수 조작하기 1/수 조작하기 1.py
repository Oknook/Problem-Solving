def solution(n, control):
    return n+sum(list({"w":1, "s":-1, "d":10, "a":-10}[x] for x in control))