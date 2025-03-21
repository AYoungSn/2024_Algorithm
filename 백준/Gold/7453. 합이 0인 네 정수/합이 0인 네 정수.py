import sys
input = lambda: sys.stdin.readline().rstrip()
    
if __name__ == "__main__":
  N = int(input())
  abcd = [list(map(int, input().split())) for _ in range(N)]
  ab = []
  cd = []
  for i in range(N):
    for j in range(N):
      ab.append(abcd[i][0] + abcd[j][1])
      cd.append(abcd[i][2] + abcd[j][3])
  ab.sort()
  cd.sort()

  answer = 0
  s, e = 0, len(cd) - 1
  while s < len(ab) and e >= 0:
    if ab[s] + cd[e] == 0:
      ns, ne = s + 1, e - 1
      while ns < len(ab) and ab[s] == ab[ns]:
        ns += 1
      while ne >= 0 and cd[e] == cd[ne]:
        ne -= 1
      answer += (e - ne) * (ns - s)
      s, e = ns, ne
    elif ab[s] + cd[e] > 0:
      e -= 1
    else:
      s += 1

  print(answer)