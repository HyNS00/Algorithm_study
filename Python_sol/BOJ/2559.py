# https://www.acmicpc.net/problem/2559
import sys
input = sys.stdin.readline

n,k = map(int,input().split())

# 연속적인 온도의 합 
# 그리드
# 어떻게 접근할까 그리드를...
# 무식하게 진행
lst = list(map(int,input().split()))
# print(lst)



current = sum(lst[:k])
result = current
for i in range(n-k):
    current = current - lst[i] + lst[i+k]
    result = max(result, current)

print(result)
# 슬라이싱 윈도우
'''
데이터나 배열에서 고정된 크기에서 윈도우를 이동시켜 연속적인 부분 구간을 처리하는 알고리즘 기법이다.
윈도우는 보통 고정된 길이를 가지며 데이터 구조에 적용된다. 윈도우를 이동시키며 데이터를 처리하므로 '슬라이싱'윈도우라고 부른다.

실행방법
1. 초기에 윈도우를 첫 번째 원소부터 고정된 크기로 설정한다.
2. 윈도우 내 구간을 처리하고 필요한 연산을 수행한다.
3. 윈도우를 한 칸 오른쪽으로 이동시킨다.
4. 이동된 윈도우에서 새로 추가된 원소를 고려하여 연산을 업데이트하거나 필요한 처리를 수행한다.
5. 윈도우가 끝까지 이동할 떄까지 반복

데이터를 연속적으로 처리하면서 반복문을 사용하는 경우보다 효율적으로 알고리즘을 구현할 수 있다.
특히, 데이터의 부분 구간을 처리하거나 최적값을 구하는 등의 문제에서 슬리이싱 윈도우는 유용하게 활용된다.

예시

def find_max_sliding_window(arr, k):
    n = len(arr)
    result = []

    # 초기 슬라이딩 윈도우의 최댓값 구하기
    max_value = max(arr[:k])
    result.append(max_value)

    # 슬라이딩 윈도우 이동
    for i in range(k, n):
        # 윈도우에서 제외되는 값과 새로 추가되는 값을 비교하여 최댓값 갱신
        if arr[i - k] == max_value:
            max_value = max(arr[i - k + 1 : i + 1])
        else:
            max_value = max(max_value, arr[i])

        result.append(max_value)

    return result
'''
# 이렇게 진행한다면 다른 값과 다르게 맨 끝과 맨 아래를 넣고 빼고 하면서 중간 값을 그대로 보존 한 채로 유지한다.
