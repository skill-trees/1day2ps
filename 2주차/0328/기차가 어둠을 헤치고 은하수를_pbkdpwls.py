N, M = map(int,input().split()) # 기차의 수,명령의 수

train = [[0 for _ in range(20)] for _ in range(N)]
state = []

for _ in range(M):
    num = list(map(int, input().split()))

    if (num[0]==1):
        train[num[1]-1][num[2]-1] = 1

    elif (num[0]==2):
        train[num[1]-1][num[2]-1] = 0

    elif (num[0]==3):
        for j in range(19, 0, -1):
            train[num[1] - 1][j] = train[num[1] - 1][j - 1]
        train[num[1] - 1][0] = 0

    elif (num[0]==4):
        for k in range(0,19):
            train[num[1]-1][k] = train[num[1]-1][k+1]
        train[num[1]-1][19] = 0

answer = 0
for i in range(N):
    if train[i] not in state:
        state.append(train[i])
        answer+=1
print(answer)




