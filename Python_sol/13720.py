# https://www.acmicpc.net/problem/13270

import sys
input = sys.stdin.readline

n = int(input())
def f(x):
    
    if x == 1:
        return 0
    
    if x == 2:
        return 1
    
    else :
        return f(x-1)+f(x-2)
