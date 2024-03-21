import sys, copy
input = lambda: sys.stdin.readline().rstrip()

# 백트래킹
# dfs -> 5번만 이동
N = int(input())
map = [list(map(int, input().split())) for _ in range(N)]
answer = 0

def up(board):
  # 상: [1..x][y] -> + [x-1][y]
  for j in range(N):
    cursor = 0
    for i in range(N):
      if board[i][j] != 0:
        tmp = board[i][j]
        board[i][j] = 0
        # cursor 는 i 보다 작거나 같고, 같으면 첫번째 if 에서 걸림
        if board[cursor][j] == 0:
          board[cursor][j] = tmp
        elif board[cursor][j] == tmp:
          board[cursor][j] *= 2
          cursor += 1
        else:
          cursor += 1 # 0이 있거나, 현재 위치
          board[cursor][j] = tmp

def down(board):
  # 하: [x-1..0][y] -> + [x + 1][y]
  for j in range(N):
    cursor = N - 1
    for i in range(N - 1, -1, -1):
      if board[i][j] != 0:
        tmp = board[i][j]
        board[i][j] = 0

        if board[cursor][j] == 0:
          board[cursor][j] = tmp
        elif board[cursor][j] == tmp:
          board[cursor][j] *= 2
          cursor -= 1
        else:
          cursor -= 1
          board[cursor][j] = tmp

def left(board):
  # 좌: [x][1..y] -> + [x][y - 1]
  for i in range(N):
    cursor = 0
    for j in range(N):
      if board[i][j] != 0:
        tmp = board[i][j]
        board[i][j] = 0

        if board[i][cursor] == 0:
          board[i][cursor] = tmp
        elif board[i][cursor] == tmp:
          board[i][cursor] *= 2
          cursor += 1
        else:
          cursor += 1
          board[i][cursor] = tmp
  
def right(board):
  # 우: [x][y-1..0] -> + [x][y + 1]
  for i in range(N):
    cursor = N - 1
    for j in range(N - 1, -1, -1):
      if board[i][j] != 0:
        tmp = board[i][j]
        board[i][j] = 0

        if board[i][cursor] == 0:
          board[i][cursor] = tmp
        elif board[i][cursor] == tmp:
          board[i][cursor] *= 2
          cursor -= 1
        else:
          cursor -= 1
          board[i][cursor] = tmp

def dfs(board, cnt):
  global answer
  if cnt >= 5:
    t = 0
    for i in range(N):
      t = max(t, *board[i])
    answer = max(answer, t)
    return
  # 상하좌우 이동 후 dfs(board, cnt + 1)
  board_t = copy.deepcopy(board)
  up(board_t)
  dfs(board_t, cnt + 1)
  board_t = copy.deepcopy(board)
  down(board_t)
  dfs(board_t, cnt + 1)
  board_t = copy.deepcopy(board)
  left(board_t)
  dfs(board_t, cnt + 1)
  board_t = copy.deepcopy(board)
  right(board_t)
  dfs(board_t, cnt + 1)


dfs(map, 0)
print(answer)