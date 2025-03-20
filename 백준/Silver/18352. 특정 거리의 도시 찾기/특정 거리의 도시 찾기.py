import sys
# from collections import defaultdict
import heapq

input = lambda: sys.stdin.readline().rstrip()
N,M,K,X = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
  A, B = map(int, input().split())
  graph[A].append((B, 1))

INF = int(1e9)
dist = [INF] * (N + 1)
heap = []
answer = []
dist[X] = 0
heapq.heappush(heap, (0, X))
while heap:
  dt, node = heapq.heappop(heap)
  for (next, weight) in graph[node]:
    if dist[next] == INF:
      dist[next] = dt + 1
      heapq.heappush(heap, (dist[next], next))
      if dist[next] == K:
        answer.append(next)

if len(answer) == 0:
  print(-1)
else:
  answer.sort()
  for a in answer:
    print(a)