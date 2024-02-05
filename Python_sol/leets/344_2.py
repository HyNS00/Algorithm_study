# https://leetcode.com/problems/reverse-string/

# 투 포인터로 풀어보자
class Solution:
    def reverseString(self, s: List[str]) -> None:
        left , right = 0, len(s) -1 # 포인터 2개를 설정
        while left < right:
            s[left],s[right] = s[right],s[left] # 포인터를 인덱스로 값을 옮긴 뒤 생성
            left += 1
            right -=1 
            # 포인터 이동
            