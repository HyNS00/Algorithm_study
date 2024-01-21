# 
# https://www.acmicpc.net/problem/14425
import sys

input = sys.stdin.readline
n,m = map(int,input().split())
one = []
two=[]
for _ in range(n):
    one.append(input().strip())

for _ in range(m):
    two.append(input().strip())
cnt =0

for j in two:
    if j in one:
        cnt += 1

print(cnt)

