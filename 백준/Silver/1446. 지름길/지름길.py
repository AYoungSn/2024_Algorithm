import sys

input = lambda: sys.stdin.readline().rstrip()
N, D = map(int, input().split())
graph = []
dist = [i for i in range(D + 1)]
for _ in range(N):
  s, e, w = map(int, input().split())
  if e - s > w:
    graph.append((s, e, w))

graph.sort()

for s, e, w in graph:
  for i in range(1, D + 1):
    if i == e: # s -> end == i
      dist[i] = min(dist[i], dist[s] + w)
    else:
      dist[i] = min(dist[i], dist[i - 1] + 1)

print(dist[D])