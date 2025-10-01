def solution(my_string, alp):
    return "".join([x.upper() if x==alp else x for x in my_string])