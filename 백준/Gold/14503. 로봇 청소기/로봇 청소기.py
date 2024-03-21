import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
DIR = 0 # 0123 - 동서남북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

N, M = map(int, input().split())
r, c, d = map(int, input().split())
# DIR 동0 -> 북3 -> 서1 -> 남2
rotate = [3, 2, 0, 1]
if d == 0:
  DIR = 3
elif d == 1:
  DIR = 0
elif d == 2:
  DIR = 2
else:
  DIR = 1

room = [list(map(int, input().split())) for _ in range(N)]

dq = deque()
dq.append((r, c))
answer = 0
while dq:
  cr, cc = dq.popleft()
  if room[cr][cc] == 0:
    room[cr][cc] = -1
    answer += 1
  cnt = 0
  for i in range(4):
    nx = cr + dx[i]
    ny = cc + dy[i]
    if nx >= 0 and ny >= 0 and nx < N and ny < M and room[nx][ny] == 0:
      cnt += 1

  if cnt == 0:
    nx = cr - dx[DIR]
    ny = cc - dy[DIR]
    if nx >= 0 and ny >= 0 and nx < N and ny < M:
      if room[nx][ny] <= 0:
        dq.append((nx, ny))
      # else:
      #   break
  else:
    for _ in range(4):
      DIR = rotate[DIR]
      nx = cr + dx[DIR]
      ny = cc + dy[DIR]
      if nx >= 0 and ny >= 0 and nx < N and ny < M and room[nx][ny] == 0:
        dq.append((nx, ny))
        break

print(answer)