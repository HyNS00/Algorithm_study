# https://www.acmicpc.net/problem/1717
# 문제를 이해하는 것에 많은 시간을 쓴 것 같다.
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
def find_parent(parent,x):
    if parent[x] != x:
        parent[x] = find_parent(parent,parent[x])
    return parent[x]
# 이 과정을 통해 각자의 parent로 넣어준다

def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a < b:
        parent[b] = a

    else :
        parent[a] = b
# 위 과정을 통해 합쳤을 경우 숫자를 작은쪽으로 향하게 만들어준다.


n,m = map(int,input().split())

lst = [i for i in range(n+1)]

for _ in range(m):
    op,a,b = map(int,input().split())

    if op == 0 :
        union_parent(lst,a,b)

    elif  op == 1:
        if find_parent(lst,a) == find_parent(lst,b):
            print("YES")
        else:
            print("NO") 