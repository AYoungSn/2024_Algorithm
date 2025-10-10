from collections import defaultdict
def solution(want, number, discount):
    answer = 0
    l, r = 0, 9
    cur = defaultdict(int)
    result = defaultdict(int)
    for i in range(len(want)):
        result[want[i]] = number[i]
    for i in range(10):
        cur[discount[i]] += 1
    while r < len(discount):
        # check
        check = True
        for key in result.keys():
            if result[key] != cur[key]:
                check = False
                break
        if check:
            answer += 1
        r += 1
        if r < len(discount):
            cur[discount[l]] -= 1
            l += 1
            cur[discount[r]] += 1
        
            
    return answer