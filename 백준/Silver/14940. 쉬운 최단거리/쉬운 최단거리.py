import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]
res = [[-1] * m for _ in range(n)]

sx, sy = -1,-1
for i in range(n):
	if 2 in board[i]:
		for j in range(m):
			if board[i][j] == 2:
				sx = i
				sy = j
				break
	if sx != -1:
		break

que = [(sx, sy)]
res[sx][sy] = 0
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
while que:
	cx, cy = que.pop(0)
	if res[cx][cy] != -1:
		for i in range(4):
			nx = cx + dx[i]
			ny = cy + dy[i]
			if nx < n and nx >= 0 and ny < m and ny >= 0 \
				and (res[nx][ny] == -1 or res[nx][ny] > res[cx][cy] + 1) and board[nx][ny] > 0:
				que.append((nx, ny))
				res[nx][ny] = res[cx][cy] + 1

for r in range(len(res)):
	for c in range(len(res[r])):
		if board[r][c] == 0:
			res[r][c] = 0
		print(res[r][c], end=" ")
	print()