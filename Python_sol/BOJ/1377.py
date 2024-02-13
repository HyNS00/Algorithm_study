# https://www.acmicpc.net/problem/1377

import sys
input =sys.stdin.readline


test = []
n = int(input())
for i in range(n):
    test.append((int(input()),i))

test.sort()

# 왼쪽으로만 이동한다. 
# 이미 10은 i가 1일 때 전부 이동을 완전히 했다. 음수가 뜨는 경우는 i가 아니라 j의 횟수 즉 이중 for문 안에서 돈 횟수이다.  
# 인덱스의 번호만을 비교해서 돈다
ans = 0
for j in range(n):
    ans = max(ans, test[j][1] -j)
print(ans+1) # +1을 해준 것은 인덱스의 차이가 0일 때, 즉 원래부터 정렬이 되어있는 경우이다.