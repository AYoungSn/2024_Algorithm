from collections import defaultdict
import math, sys

sys.setrecursionlimit(20000000)

# W[i][j] = i 에서 j 로 이동할 때의 가중치
W = [
    [1, 7, 6, 7, 5, 4, 5, 3, 2, 3], # 0
    [7, 1, 2, 4, 2, 3, 5, 4, 5, 6],
    [6, 2, 1, 2, 3, 2, 3, 5, 4, 5],
    [7, 4, 2, 1, 5, 3, 2, 6, 5, 4], # 3
    [5, 2, 3, 5, 1, 2, 4, 2, 3, 5], # 4
    [4, 3, 2, 3, 2, 1, 2, 3, 2, 3], # 5
    [5, 5, 3, 2, 4, 2, 1, 5, 3, 2], # 6
    [3, 4, 5, 6, 2, 3, 5, 1, 2, 4], # 7
    [2, 5, 4, 5, 3, 2, 3, 2, 1, 2], # 8
    [3, 6, 5, 4, 5, 3, 2, 4, 2, 1]
]

dp = defaultdict(dict)

def solution(numbers):
    answer = 0
    return dfs(0, 4, 6, numbers)

def dfs(i, left, right, numbers):
    if i >= len(numbers):
        return 0
    if (left, right) in dp[i]:
        return dp[i][(left, right)]
    num = int(numbers[i])
    w = float('INF')
    if num != right:
        w = min(dfs(i + 1, num, right, numbers) + W[left][num], w)
    if num != left:
        w = min(dfs(i + 1, left, num, numbers) + W[right][num], w)
    dp[i][(left, right)] = w
    return w