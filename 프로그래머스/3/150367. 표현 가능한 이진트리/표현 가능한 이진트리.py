def dfs(num, i, diff, zero): # zero == True 이면 부모노드가 0
    if (i + 1) % 2 != 0: # 마지막 노드
        if not zero or num[i] == '0':
            return True
    if zero and num[i] == '1':
        return False
    if num[i] == '0':
        zero = True
    if (i + 1) + diff - 1 < len(num) and not dfs(num, (i + 1) + diff - 1, diff//2, zero):
        return False
    if (i + 1) - diff - 1 >= 0 and not dfs(num, (i + 1) - diff - 1, diff//2, zero):
        return False
    return True
            
def solution(numbers):
    answer = []
    for t in range(len(numbers)):
        num = bin(numbers[t])[2:]
        m = 1
        n = 1
        while m < len(num):
            m += n * 2
            n *= 2
        for i in range(0, m - len(num)):
            num = '0' + num
        # print(m, num)
        nodeCnt = ((2 ** (len(num) - 1)) - 1)
        if dfs(num, len(num)//2, (len(num)//2 + 1)//2, False):
            answer.append(1)
        else:
            answer.append(0)
    return answer

def solution2(numbers):
    answer = []
    for number in numbers:
        bnum = bin(number)[2:]
        nodeCnt = ((2 ** (len(bnum) - 1)) - 1)
        print(bnum)
        bnum = '0' * (nodeCnt - len(bnum)) + bnum
        print(nodeCnt, bnum)
    return answer