import itertools

# 재귀함수로 조합 구현
def combination_(arr,n):
    result = []
    if n==0:
        return [[]]
    for i in range(0, len(arr)):
        a = arr[i]
        temp = arr[i+1:]
        for j in combination_(temp, n-1):
            result.append([a]+j)
    return result

arr = []
for i in range(9):
    arr.append(int(input()))

# a = itertools.combinations(arr,7)
a = combination_(arr,7)

answer = []
for i in a:
    if (sum(i)==100):
        answer = i
        break

for i in sorted(answer):
    print(i)