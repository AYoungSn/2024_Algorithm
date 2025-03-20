import sys
input = lambda: sys.stdin.readline().rstrip()
N, D = map(int, input().split())
graph = []
dist = [i for i in range(D + 1)]
for _ in range(N):
  s, e, w = map(int, input().split())
  if e - s > w and e <= D:
    graph.append((s, e, w))
graph.sort()

for s, e, w in graph:
  dist[e] = min(dist[e], dist[s] + w)
  for i in range(e, D + 1):
    dist[i] = min(dist[i], dist[i - 1] + 1)

print(dist[D])
