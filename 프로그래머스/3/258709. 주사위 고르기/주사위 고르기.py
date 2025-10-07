from itertools import combinations, product
from collections import defaultdict

def solution(dice):
    answer = []
    n = len(dice)
    max_cnt = 0
    for choose in combinations(range(n), n//2):
        choose_dice = [dice[i] for i in choose]
        A_probability = defaultdict(int)
        # print(list(product(*choose_dice)))
        for p in product(*choose_dice):
            A_probability[sum(p)] += 1
        
        not_choose = tuple(set(range(n)) - set(choose))
        not_choose_dice = [dice[i] for i in not_choose]
        B_probability = defaultdict(int)
        for p in product(*not_choose_dice):
            B_probability[sum(p)] += 1
        
        preSum = [0] * 501
        S = 0
        # B 가 얻을 수 있는 주사위 조합의 합의 누적합
    
        for i in range(1, 501):
            if i in B_probability:
                S += B_probability[i]
            preSum[i] = S
        
        # A 가 얻은 주사위 합 * A 합보다 작은 B 의 누적합
        cnt = 0
        for k, v in A_probability.items():
            cnt += v * preSum[k - 1]
            
        if max_cnt < cnt:
            max_cnt = cnt
            answer = [i + 1 for i in choose]

    return answer