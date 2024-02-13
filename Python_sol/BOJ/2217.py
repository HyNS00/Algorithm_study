# https://www.acmicpc.net/problem/2217
import sys

input = sys.stdin.readline

n = int(input())
'''
n개의 로프를 사용하여 무게를 나눈다.
중량이 w인 물체를 들어올릴 때, k개의 로프를 사용 -> w/k만큼 중량 사용

n개의 무게가 들린다

하나의 로프의 중량이 w/k


'''
rope =[]
for _ in range(n):
    k = int(input())
    rope.append(k)

rope.sort()

x = 0
for i in range(len(rope)):

    x = max(x, rope[i] *(len(rope)-i))

print(x)