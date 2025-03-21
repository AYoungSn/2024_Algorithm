import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()
N, K = map(int, input().split())
INF = int(1e11)
que = deque([N])
dist = [INF] * 100001
dist[N] = 0

while que:
  cur = que.popleft()
  if cur == K:
    break
  if cur + 1 < 100001 and dist[cur + 1] > dist[cur] + 1:
    dist[cur + 1] = dist[cur] + 1
    que.append(cur + 1)
  if cur - 1 >= 0 and dist[cur - 1] > dist[cur] + 1:
    dist[cur - 1] = dist[cur] + 1
    que.append(cur - 1)
  if cur * 2 < 100001 and dist[cur * 2] > dist[cur]:
    dist[cur * 2] = dist[cur]
    que.append(cur * 2)

print(dist[K])