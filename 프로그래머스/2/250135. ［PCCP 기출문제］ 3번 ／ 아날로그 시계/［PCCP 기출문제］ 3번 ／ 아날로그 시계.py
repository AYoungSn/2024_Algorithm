def getAlarmCnt(h, m, s):
    count = 0
    # 00 h ~ h h
    count += h * 60 * 2 - h
    # 00 m ~ m m
    count += m * 2
    hr, mr, sr = (h * 30 + m * 0.5 + s * 1/120) % 360, (m * 6 + s * 0.1) % 360, (s * 6) % 360
    if mr <= sr:
        count += 1
    if hr <= sr:
        count += 1
    if h >= 12:
        count -= 2
    print(count)
    
    return count
def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    # 시침 각도 -> 1시간에 30도 - 360/12 -> 1분에 0.5도 -> 1초에 1/120
    # 분침 각도 -> 1시간에 360도 -> 1분에 360/60 - 6도 -> 1초에 1/10
    # 초침 각도 -> 1시간에 360도 * 60 -> 1분에 360도 -> 1초에 6도
    # 시침과 초침이 겹치는 횟수 구하기
    # 분침과 초침이 겹치는 횟수
    # 두개를 더한 후 시침/분침/초침이 겹치는 횟수 빼기
    # 1 분당 시침과 초침이 겹치는 횟수, 분침과 초침이 겹치는 횟수
    # 1 시간당 시침과 초침이 겹치는 횟수, 분침과 초침이 겹치는 횟수
    # 시작 시간 ~ 종료 시간 동안 겹치는 각도 계산하기
    h, m, s = h1, m1, s1
    
    res = getAlarmCnt(h2, m2, s2) - getAlarmCnt(h1, m1, s1)
    if (h1 % 12 == 0) and m1 == 0 and s1 == 0:
        res += 1
    return res