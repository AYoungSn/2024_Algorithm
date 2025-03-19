import sys
from collections import defaultdict
input = lambda:sys.stdin.readline().rstrip()
N = int(input())
tree = defaultdict(list)

for _ in range(N):
  node, left, right = input().split()
  tree[node] = [left, right]

def preOrder(cur):
  print(cur, end='')
  if tree[cur][0] != '.':
    preOrder(tree[cur][0])
  if tree[cur][1] != '.':
    preOrder(tree[cur][1])

def inOrder(cur):
  if tree[cur][0] != '.':
    inOrder(tree[cur][0])
  print(cur, end='')
  if tree[cur][1] != '.':
    inOrder(tree[cur][1])

def postOrder(cur):
  if tree[cur][0] != '.':
    postOrder(tree[cur][0])
  if tree[cur][1] != '.':
    postOrder(tree[cur][1])
  print(cur, end='')
preOrder('A')
print()
inOrder('A')
print()
postOrder('A')