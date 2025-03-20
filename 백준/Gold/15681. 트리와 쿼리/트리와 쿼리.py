import sys
sys.setrecursionlimit(10**6)
input = lambda: sys.stdin.readline().rstrip()

N, R, Q = map(int, input().split())
graph = [[] for _ in range(N + 1)]
subtree = [0] * (N + 1)
for _ in range(N - 1):
  u, v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

def dfs(vertex):
  global subtree
  subtree[vertex] = 1
  for i in graph[vertex]:
    if subtree[i] == 0:
      subtree[vertex] += dfs(i)
  return subtree[vertex]

dfs(R)

for _ in range(Q):
  q = int(input())
  print(subtree[q])