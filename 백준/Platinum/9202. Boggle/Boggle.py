import sys

input = lambda: sys.stdin.readline().rstrip()

dx = [-1,1,0,0,-1,1,-1,1]
dy = [0,0,-1,1,-1,-1,1,1]



w = int(input())
word_dictionary = []
for _ in range(w):
    word_dictionary.append(input().strip())
input()




def solution():
  b = int(input())

  trie = make_trie()

  for _ in range(b):
    board = [list(input()) for _ in range(4)]
    input()
    search_result = set()
    visited = [[False] * 4 for _ in range(4)]
    for x in range(4):
      for y in range(4):
        now = trie
        for child in now.child:
          if child and board[x][y] == child.alpha:
            visited[x][y] = True
            search_word(child, x, y, board, board[x][y], visited, search_result)
            visited[x][y] = False
            break
    long_word = ''
    score = 0
    search_result = list(search_result)
    search_result.sort()
    for word in search_result:
      if len(long_word) < len(word):
        long_word = word
      if 3 <= len(word) <= 4:
        score += 1
      elif len(word) == 5:
        score += 2
      elif len(word) == 6:
        score += 3
      elif len(word) == 7:
        score += 5
      elif len(word) == 8:
        score += 11
    print(score, long_word, len(search_result))
    
def search_word(cur, x, y, board, word, visited, search_result):
  if cur.isWord:
    search_result.add(word)

  if len(word) == 8:
    return
  
  for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]

    if nx >= 0 and nx < 4 and ny >= 0 and ny < 4 and not visited[nx][ny]:
      for child in cur.child:
        if child and child.alpha == board[nx][ny]:
          visited[nx][ny] = True
          search_word(child, nx, ny, board, word + board[nx][ny], visited, search_result)
          visited[nx][ny] = False
  

def make_trie():
  trie = Node()

  for word in word_dictionary:
    insert_trie_node(trie, word)
  return trie

def insert_trie_node(root, word):
  cur = root
  for wo in word:
    flag = False
    for child in cur.child:
      if wo == child.alpha:
        flag = True
        cur = child
        break
    if not flag:
      node = Node(wo)
      cur.child.append(node)
      cur = node
  cur.isWord = True

class Node:
  def __init__(self, alpha = ''):
    self.alpha = alpha
    self.child = []
    self.isWord = False
  
solution()