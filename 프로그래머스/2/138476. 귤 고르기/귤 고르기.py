from collections import defaultdict
def solution(k, tangerine):
    answer = 0
    N = len(tangerine)
    tang = defaultdict(int)
    for i in range(N):
        tang[tangerine[i]]+= 1
    result = list(tang.values())
    result.sort(reverse=True)
    cnt = 0
    for i in range(len(result)):
        if cnt < k:
            cnt += result[i]
            answer += 1
        else:
            break
    return answer