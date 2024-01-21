# https://www.acmicpc.net/problem/2447

import sys

input = sys.stdin.readline

n = int(input())

N = n // 3
if N == 1:
    print('***')
    print('* *')
    print('***')

