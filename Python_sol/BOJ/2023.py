# https://www.acmicpc.net/problem/2023
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
'''
해당 문제는 한자리씩 늘려가면서 확인한다
예를 들어 7331일 경우
7, 73, 733, 7331 모두 소수여야 한다
따라서 맨 왼쪽자리 수는 2 3 5 7 중 하나여야한다.
그 다음 2 3 5  7 뒤에 짝수가 온다면 절대로 소수가 될 수 없으므로
1 3 5 7 9만 와야한다.

근데 그걸 생각 안해도 상관은 없을려나?
그냥 하면 runtimeerror
'''
def find(num):
    if num < 2:
        return False

    for i in range(2,int(num ** 0.5)+1):
        if num % i == 0:
            return False
        
    return True

def dfs(cur, depth, n):
    if depth == n :
        print(cur)
    for i in range(10):
        num = cur * 10 +i
        if find(num):
            dfs(num,depth +1,n)

'''
dfs 함수에서 n자리 일 때 출력을 하는 방식을 다음과 같이 바꿔도 좋다
def dfs(cur):
    if len(str(cur)) == n:
        print(cur)
'''
n = int(input())
dfs(2,1,n)
dfs(3,1,n)
dfs(5,1,n)
dfs(7,1,n)