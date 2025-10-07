from itertools import combinations

def solution(n, q, ans):
    answer = 0
    numlist = [i for i in range(1, n + 1)]
    
    for comb in combinations(numlist, 5):
        same = []
        for check in q:
            cnt = 0
            for i in comb:
                if i in check:
                    cnt += 1
            same.append(cnt)
        if same == ans:
            answer += 1
    
    return answer