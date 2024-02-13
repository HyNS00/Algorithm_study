# https://www.acmicpc.net/problem/25192

import sys
input = sys.stdin.readline

n = int(input())

s = set()
ans = 0
# 집합의 내용에 대해 공부
# ENTER가 들어올 때마다 그에 대한 답을 제공

for i in range(n):
    user = input().strip()
    if user =='ENTER':
        ans += len(s)
        s.clear()

    else :
        s.add(user)

ans += len(s)
print(ans)