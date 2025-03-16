import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
N = int(input())
board = [list(input()) for _ in range(N)]
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
answer = []
for i in range(N):
  for j in range(N):
    if board[i][j] == '1':
      que = deque([(i, j)])
      cnt = 1
      board[i][j] = '0'
      while len(que) >0:
        cx, cy = que.popleft()
        for k in range(4):
          nx = dx[k] + cx
          ny = dy[k] + cy
          if nx >= 0 and nx < N and ny >= 0 and ny < N and board[nx][ny] == '1':
            board[nx][ny] = '0'
            cnt += 1
            que.append((nx, ny))
      answer.append(cnt)

print(len(answer))
answer.sort()
for ans in answer:
  print(ans)