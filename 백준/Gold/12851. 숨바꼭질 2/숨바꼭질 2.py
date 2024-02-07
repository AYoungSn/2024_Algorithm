import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
INF = float('inf')
arr = [INF] * 100001

arr[N] = 0
arr[K] = abs(N - K) + 2
que = deque()
que.append(N)
if N == K:
    print(0)
    print(1)
else:
    res = abs(N - K) + 2
    cnt = 0
    while que:
        cur = que.popleft()
        if cur == K and arr[K] < res:
            res = arr[K]
            cnt = 1
            continue
        elif cur == K and arr[K] != INF and arr[K] == res:
            cnt += 1
            continue
        if cur + 1 <= 100000 and (arr[cur] + 1 <= arr[cur + 1]):
            arr[cur + 1] = arr[cur] + 1
            que.append(cur + 1)
        if cur - 1 >= 0 and ( arr[cur] + 1 <= arr[cur - 1]):
            arr[cur - 1] = arr[cur] + 1
            que.append(cur - 1)
        if cur * 2 <= 100000 and ( arr[cur] + 1 <= arr[cur * 2]):
            arr[cur * 2] = arr[cur] + 1
            que.append(cur * 2)
        
    print(arr[K])
    print(cnt)
