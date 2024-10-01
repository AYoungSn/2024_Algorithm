import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()

N=int(input())
arr = list(map(int, input().split()))
M = int(input())
se = [list(map(int, input().split())) for _ in range(M)]
dp = [[True] * N for _ in range(N)]

for s in range(N - 1, -1, -1):
    for e in range(s, N):
        if s == e:
            dp[s][e] = True
            continue
        elif s + 1 == e:
            if arr[s] == arr[e]:
                dp[s][e] = True
            else:
                dp[s][e] = False
        else:
            if dp[s + 1][e - 1] and arr[s] == arr[e]:
                dp[s][e] = True
            else:
                dp[s][e] = False

for s, e in se:
    if dp[s-1][e-1]:
        print(1)
    else:
        print(0)