from collections import defaultdict

def solution(friends, gifts):
    answer = 0
#     1. 선물 주고받은 기록 있는 경우, 더 많이 준 사람이 다음달에 하나 받음
# 2. 없거나 주고받은 수가 같다면, 선물지수가 큰 사람이 작은 사람에게 선물 받음
# 선물 지수 = 이번 달까지 보낸 선물 수 - 받은 선물 수
# 두 사람의 선물 지수가 같으면 다음달에 선물을 주고받지 않음
    # 선물 지수, 선물 주고받은 기록
    giftNum, giftCnt = giftnum(friends, gifts)
    # 
    res = defaultdict(int)
    for i in range(len(friends)):
        for j in range(i + 1, len(friends)):
            if giftCnt[friends[i] + ' ' + friends[j]] == giftCnt[friends[j] + ' ' + friends[i]]:
                if giftNum[friends[i]] < giftNum[friends[j]]:
                    res[friends[j]] += 1
                elif giftNum[friends[i]] > giftNum[friends[j]]:
                    res[friends[i]] += 1
            elif giftCnt[friends[i] + ' ' + friends[j]] > giftCnt[friends[j] + ' ' + friends[i]]:
                res[friends[i]] += 1
            elif giftCnt[friends[i] + ' ' + friends[j]] < giftCnt[friends[j] + ' ' + friends[i]]:
                res[friends[j]] += 1
            
#             if giftCnt[' '.join([friends[i], friends[j]])] < giftCnt[' '.join([friends[j], friends[i]])]:
#                 res[friends[j]] += 1
#             elif giftCnt[' '.join([friends[i], friends[j]])] > giftCnt[' '.join([friends[j], friends[i]])]:
#                 res[friends[i]] += 1
#             else:
#                 if giftNum[friends[i]] > giftNum[friends[j]]:
#                     res[friends[i]] += 1
#                 elif giftNum[friends[i]] < giftNum[friends[j]]:
#                     res[friends[j]] += 1
    for k, v in res.items():
        if answer < v:
            answer = v
    
    return answer

def giftnum(friends, gifts):
    giftNum = defaultdict(int)
    count = defaultdict(int)
    for i in range(len(gifts)):
        a, b = gifts[i].split()
        giftNum[a] += 1
        giftNum[b] -= 1
        count[gifts[i]] += 1
        
    return giftNum, count