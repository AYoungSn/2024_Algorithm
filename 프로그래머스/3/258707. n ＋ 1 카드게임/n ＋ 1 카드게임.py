def solution(coin, cards):
    answer = 0
    hobo = []
    n = len(cards)
    current = [cards[i] for i in range(n // 3)]
    current.sort()
    curIdx = n // 3
    round = 1
    while True:
        if curIdx >= n:
            break
        if round > n // 3 + 1:
            break
        
        hobo.append(cards[curIdx])
        hobo.append(cards[curIdx + 1])
        curIdx += 2
        if findNplus1(current, n):
            round += 1
            continue
        
        if coin > 0:
            check = False
            for hb in hobo:
                if (n + 1 - hb) in current:
                    current.remove(n + 1 - hb)
                    round += 1
                    coin -= 1
                    hobo.remove(hb)
                    check = True
                    break
            if check:
                continue
            
        if coin > 1:
            if findNplus1(hobo, n):
                round += 1
                coin -= 2
                continue
            else:
                break
        else: break
        
    return round


def findNplus1(arr, n):
    arr.sort()
    for i in range(len(arr)):
        target = n + 1 - arr[i]
        
        l = 0
        r = len(arr) - 1
        while l <= r:
            mid = (l + r) // 2
            if arr[mid] < target:
                l = mid + 1
            elif arr[mid] > target:
                r = mid - 1
            else:
                arr.remove(arr[mid])
                arr.remove(arr[i])
                return True
    return False