# https://www.acmicpc.net/problem/1463

# 다시 풀어보자
# 다이나믹 프로그래밍

import sys
input = sys.stdin.readline
'''
내가 틀린 이유
1. 다이나믹 프로그래밍을 생각해 내지 못 했다.
2. for문을 돌릴 때 range(3,x+1)이다.
3. 각각의 배수에서 나눠준 값 vs 전에 값   -->  +1어떤 것을 넣어주는 것이 맞을지 생각
4. 6의 배수까지 고려해준다면 아마 dp[2] =1을 넣어주는 것이 편하다.
'''
n = int(input())
dp =[0] * (n+1)
dp[1] = 0
if n > 1:
    dp[2] = 1
    for i in range(3,n+1):
        
        if i % 2 == 0 and i % 3 == 0:
            dp[i] = min(dp[i//2],dp[i-1], dp[i//3])+1

        elif i % 3 == 0 :
            dp[i] = min(dp[i-1], dp[i//3]) + 1

        elif i % 2 == 0 :
            dp[i] = min(dp[i//2], dp[i-1]) +1

        else :
            dp[i] = dp[i-1] +1 
    

print(dp[n])