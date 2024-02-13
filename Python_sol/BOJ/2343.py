# https://www.acmicpc.net/problem/2343
import sys
input = sys.stdin.readline

n,m = map(int,input().split())

blue = list(map(int,input().split()))

'''
binary search를 어떻게 활용할것인가

몇 개로 구분할 수 있는걸 어떻게 이분탐색으로 활용할까?
블루레이의 값이 가장 작다는 의미는 해당 블루레이의 값이 모든 블루레이들의 값보다 커야한다

즉 시작점이 되는 건 리스트로 받은 숫자들 중 가장 큰 값이 될 수 있다
그렇다면 블루레이의 숫자를 가장 많이(리스트의 수 만큼) 쓸 수 있고 가장 큰 값이 가장 작은 블루레이 값이 된다.


끝점은 ?
물론 모든 리스트의 값을 합쳐놓고 블루레이가 1개일 때의 값이 된다.
이것을 명심해서 진행하고 갯수가 모자라면 +1을 넣는 방식으로 업데이트를 해보자

블루레이의 개수가 많으면 블루레이 크기를 늘리고, 블루레이 개수가 적으면 블루레이 크기를 줄여가며 이분탐색을 한다.
'''
start = max(blue)
end = sum(blue)
while start <= end:

    mid = (start+end) // 2
    cnt = 1 # 처음에 원래 하나
    total = 0
    for i in range(n):
        
        if total + blue[i] > mid :
            cnt += 1
            total = 0 # 합을 초기화 해주는 상황이 필요하다
        total += blue[i]

    if cnt <= m:
        end = mid -1

    else:
        start = mid +1

print(start)



