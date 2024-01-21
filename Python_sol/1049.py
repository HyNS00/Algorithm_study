# https://www.acmicpc.net/problem/1049
import sys

input = sys.stdin.readline

# n개의 줄이 끈허짐
# 6개 줄(세트) 혹은 낱개

# n = 끊어진 기타 줄
# m=  브랜드
n,m = map(int,input().split())
# single = []  
# package = []
# 매번 min을 통해서 값을 초기화 해주는 것이 메모리를 덜 잡아 먹는다.
single= package = sys.maxsize
for _ in range(m):
    a,b = map(int,input().split())
    package = min(a,package) # 20
    single = min(b, single) # 4


result = n * single
ans = 0
while n > 0:
    if n * single < package:
       ans += n* single
       n -= n

    else:
        ans += package
        n -= 6

print(min(ans,result)) 


''' 원주의 풀이
import sys
input = sys.stdin.readline
n,m = map(int,input().split())
single = package = sys.maxsize

for _ in range(m):
    a,b = map(int,input().split())
    package = min(a,package)
    single = min(b,single)

# 최소 패키지와 최소 낱개 갯수로 만 구매
result = sys.maxsize
ans = (n //6) * package + (n % 6) * single 
result = min(result,n*single, ans, package*(n//6 +1))
print(result)
# (n//6 )+1이 의미하는 것은 package로 하나를 더 구매했을 때까 적어도 n개를 구매했을 때보다 싸기 때문에
# 이를 고려한 것 
'''