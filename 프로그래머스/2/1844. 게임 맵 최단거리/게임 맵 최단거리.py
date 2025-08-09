dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(visit, maps):
	global dx, dy
	que = [(0, 0, 1)]
	while (len(que) > 0):
		x, y, dist = que.pop(0)
		for i in range(4):
			nx = dx[i] + x
			ny = dy[i] + y
			if nx >= 0 and nx < len(maps) and ny >= 0 and ny < len(maps[0]) \
				and maps[nx][ny] == 1 and (visit[nx][ny] == 0 or visit[nx][ny] < dist):
				if visit[nx][ny] == 0 or visit[nx][ny] >= dist:
					visit[nx][ny] = dist + 1
				else:
					continue
				que.append((nx, ny, dist + 1))
	return 

	

def solution(maps):
	answer = 0
	visit = [[0 for _ in range(len(maps[0]))] for _ in range(len(maps))]

	que = [(0, 0, 1)]
	visit[0][0] = 1
	bfs(visit, maps)

	if visit[len(maps) - 1][len(maps[0]) -1] == 0:
		return -1
	return visit[len(maps) - 1][len(maps[0]) -1]