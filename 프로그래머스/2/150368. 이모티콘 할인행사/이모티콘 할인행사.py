totalCount = 0
totalSales = 0
def solution2(users, emoticons):
    answer = [0, 0]
    dfs(emoticons, 0, [0] * len(users), users)
    return [totalCount, totalSales]

def dfs(emoticons, ind, count, users):
    global totalCount, totalSales
    if len(emoticons) <= ind:
        plus = 0
        sales = 0
        for i in range(len(users)):
            if users[i][1] <= count[i]:
                plus += 1
            else:
                sales += count[i]
        if totalCount < plus:
            totalCount = plus
            totalSales = sales
        elif totalCount == plus and totalSales < sales:
            totalSales = sales
        return
    for disc in [10, 20, 30, 40]:
        price = emoticons[ind] * (100 - disc) // 100
        addCnt = count.copy()
        # 사용자가 구매할 경우 계산
        for i in range(len(users)):
            if users[i][0] <= disc:
                addCnt[i] += price
        dfs(emoticons, ind + 1, addCnt, users)
        
        
def solution(users, emoticons):
    global answer
    answer = [0,0]
    dfs2(users, emoticons, [0] * len(users), 0)
    return answer

def dfs2(users, emoticons, purchases, index):
    global answer
    if index >= len(emoticons):
        cnt = 0
        sales = 0
        for i in range(len(users)):
            if purchases[i] >= users[i][1]:
                cnt += 1
            else:
                sales += purchases[i]
        if answer[0] < cnt:
            answer = [cnt, sales]
        elif answer[0] == cnt and answer[1] < sales:
            answer = [cnt, sales]
        return
    for discount in [10, 20, 30, 40]:
        price = emoticons[index] * (100 - discount)//100
        pCopy = purchases[:]
        for i in range(len(users)):
            if discount >= users[i][0]:
                pCopy[i] += price
        dfs2(users, emoticons, pCopy, index + 1)
        