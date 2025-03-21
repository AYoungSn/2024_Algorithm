import sys
from collections import defaultdict
import heapq
input = lambda: sys.stdin.readline().rstrip()
N = int(input())
M = int(input())
graph = defaultdict(list)

for _ in range(M):
  s, e, w = map(int, input().split())
  graph[s].append((e, w))

A, B = map(int, input().split())

heap = []
heapq.heappush(heap, (0, A))

INF = int(1e9)
dist = [INF] * (N + 1)
dist[A] = 0
visited = [False] * (N + 1)
while heap:
  weight, cur = heapq.heappop(heap)
  if visited[cur]:
    continue
  visited[cur] = True
  for e, w in graph[cur]:
    if dist[e] > dist[cur] + w:
      dist[e] = dist[cur] + w
      heapq.heappush(heap, (dist[e], e))

print(dist[B])