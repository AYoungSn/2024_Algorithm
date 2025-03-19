import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

acc_board = [[0] * (N + 1) for _ in range(N + 1)]
acc_board[0][0] = board[0][0]
for i in range(N):
  for j in range(N - 1):
    board[i][j + 1] += board[i][j]
for i in range(N - 1):
  for j in range(N):
    board[i + 1][j] += board[i][j]

# print(board)
for _ in range(M):
  x1, y1, x2, y2 = map(int, input().split())
  s = board[x2 - 1][y2 - 1]
  if x1 - 2 >= 0 and y1 - 2 >= 0:
    s += board[x1 - 2][y1 - 2]
  if x1 - 2 >= 0 and y2 - 1 >= 0:
    s -= board[x1 - 2][y2 - 1]
  if x2 - 1 >= 0 and y1 - 2 >= 0:
    s -= board[x2 - 1][y1 - 2]
  print(s)