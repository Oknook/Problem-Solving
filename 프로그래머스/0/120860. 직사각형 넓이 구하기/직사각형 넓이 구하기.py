def solution(dots):
    l = list(zip(*dots))
    return (max(l[0])-min(l[0]))*(max(l[1])-min(l[1]))