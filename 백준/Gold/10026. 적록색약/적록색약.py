import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
N = int(input())
board = [list(input()) for _ in range(N)]
board_rg = [board[i][:] for i in range(N)]
dx, dy = [1, 0, -1, 0], [0, 1,0,-1]

def getRGColor(color):
  if color == 'R' or color == 'G':
    return 'R'
  else:
    return color
# normal
normal = 0
for i in range(N):
  for j in range(N):
    if board[i][j] == '0':
      continue
    cur = board[i][j]
    board[i][j] = '0'
    normal += 1
    que = deque([(i,j)])
    while len(que) > 0:
      cx, cy = que.popleft()
      for k in range(4):
        nx = dx[k] + cx
        ny = dy[k] + cy
        if nx >= 0 and nx < N and ny >= 0 and ny < N:
          if board[nx][ny] == cur:
            board[nx][ny] = '0'
            que.append((nx, ny))
# rg/b
rg = 0
for i in range(N):
  for j in range(N):
    if board_rg[i][j] == '0':
      continue
    cur = getRGColor(board_rg[i][j])
    board_rg[i][j] = '0'
    rg += 1
    que = deque([(i,j)])
    while len(que) > 0:
      cx, cy = que.popleft()
      for k in range(4):
        nx = dx[k] + cx
        ny = dy[k] + cy
        if nx >= 0 and nx < N and ny >= 0 and ny < N:
          if getRGColor(board_rg[nx][ny]) == cur:
            board_rg[nx][ny] = '0'
            que.append((nx, ny))

print(normal, rg)

