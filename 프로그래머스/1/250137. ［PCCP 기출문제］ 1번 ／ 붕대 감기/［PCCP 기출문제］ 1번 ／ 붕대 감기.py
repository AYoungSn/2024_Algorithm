def solution(bandage, health, attacks):
    answer = 0
    # 붕대 감으면서 1초마다 x 회복, t 초 연속 성공 시 y 만큼 회복 (상한선 존재)
    # 감다가 공격 당하면 취소됨, 체력 회복 불가
    # 다시 감기 시작, 연속 성공 시간 0 초기화
    # 공격 받으면 정해진만큼 체력 줄어듦, 0 이하가 되면 죽음, 회복 불가
    timer = 1
    max_health = health
    for time, attack in attacks:
        # time - timer - 1 만큼 연속 회복
        t = time - timer
        health += t * bandage[1] + (t // bandage[0]) * bandage[2]
        timer = time + 1
        if health > max_health:
            health = max_health
        health -= attack
        if health <= 0:
            break
    if health <= 0:
        health = -1
    return health