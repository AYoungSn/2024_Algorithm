#2시간
import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()
T = int(input())

for _ in range(T):
	V, E = map(int, input().split())
	arr = defaultdict(list)
	uf = [0] * (V + 1)
	que = []
	for _ in range(E):
		u, v = map(int, input().split())
		arr[u].append(v)
		arr[v].append(u)
	A = set()
	B = set()
	for k in arr.keys():
		if not uf[k]:
			que.append(k)
			uf[k] = 1
			A.add(k)
		while que:
			cur = que.pop(0)
			v = 1
			if uf[cur] == 1:
				v = 2
			for i in arr[cur]:
				if not uf[i]:
					if v == 1:
						A.add(i)
					else:
						B.add(i)
					uf[i] = v
					que.append(i)
	check = True
	for k in arr.keys():
		if uf[k] != 0:
			for i in arr[k]:
				if uf[k] == uf[i]:
					check = False
					break
			if not check:
				break
	if check:
		print('YES')
	else:
		print('NO')
