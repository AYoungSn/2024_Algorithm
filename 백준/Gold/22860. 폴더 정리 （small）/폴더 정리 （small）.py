import sys
from collections import defaultdict
sys.setrecursionlimit(10**8)

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

# main / folder
# main / file1
# folder / fd1

dirs = defaultdict(list)

def dfs(query, files):
  global total
  for to, f in dirs[query]:
    if f == 0:
      files.add(to)
      total += 1
    else:
      dfs(to, files)

for i in range(N + M):
  a, b, f = input().split()
  dirs[a].append([b, int(f)])

q = int(input())
for i in range(q):
  files = set()
  total = 0
  query = input().split('/')
  dfs(query[-1], files)
  print(len(files), total)
  
