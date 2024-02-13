# https://www.acmicpc.net/problem/1057
import sys
input = sys.stdin.readline
n,j,h = map(int,input().split())
cnt = 1
# 만날 때까지 절대 지지 않으니 return -1을 고려할 이유는 없다.

cnt = 0
# 둘이 같은 숫자면 만난다, 차이가 없다고 생각
while j != h:
    j = j//2 + j%2
    h = h//2 + h%2
    # 업데이트를 할 때, j가 짝수라면 j%2가 어차피 0이므로 의미가 없으니 더해줘도 된다.
    # 그게 아니라면 import math + math.ceil방법을 통해 반올림을 진행해준다.
    cnt += 1

print(cnt)