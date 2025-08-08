import sys, heapq
from collections import defaultdict
# 다익스트라 버전
input = lambda : sys.stdin.readline().rstrip()

N, M = map(int, input().split())

INF = float('inf')
rel = defaultdict(list)

for _ in range(M):
  a, b = map(int, input().split())
  rel[a].append((b, 1))
  rel[b].append((a, 1))

def dijkstra():
  answer = []
  for k in range(1, N + 1):
    que = []
    heapq.heappush(que, (0, k))
    dist = defaultdict(int)
    while que:
      time, node = heapq.heappop(que)
      if node not in dist:
        dist[node] = time # node 까지 온 비용: time
        for v, w in rel[node]:
          heapq.heappush(que, (time + w, v)) # v 노드까지 온 비용: time + w
    answer.append((sum(dist.values()), k))
  answer.sort()
  print(answer[0][1])

dijkstra()