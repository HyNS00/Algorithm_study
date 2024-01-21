# https://www.acmicpc.net/problem/1764
import sys

input = sys.stdin.readline

n,m = map(int,input().split())

n_hear =set([input().strip() for _ in range(n)])
n_see = set([input().split() for _ in range(m)])

final =list(n_hear & n_see)
final.sort()

print(len(final))
for i in final:
    print(i)