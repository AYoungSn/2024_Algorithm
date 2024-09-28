import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
fruits = list(map(int, input().split()))

l,r,cnt = 0,0,0
answer = 0
infos = defaultdict(int)

while r < N:
    if infos[fruits[r]] == 0:
        cnt += 1
    infos[fruits[r]] += 1
    while cnt > 2:
        infos[fruits[l]] -= 1
        if infos[fruits[l]] == 0:
            cnt -= 1
        l += 1
    answer = max(answer, r - l + 1)
    r += 1
    
print(answer)