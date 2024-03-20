import math

def solution(r1, r2):
    answer = r2 - r1 + 1 # y 축 위에 있는 점 개수
    rr1 = r1**2
    rr2 = r2**2
    # x**2 + y**2 = r**2
    # 1사분면
    # x: 0~r2
    for x in range(1, r2):
        # r2 까지 점 개수 - r1 전까지 점 개수
        # y = sqrt(r**2 - x**2)
        xx = x**2
        maxY = math.floor(math.sqrt(rr2 - xx))
        if x < r1:
            minY = math.ceil(pow(rr1 - xx, 0.5))
            answer += maxY - minY + 1
        else:
            answer += maxY
    
    return answer * 4