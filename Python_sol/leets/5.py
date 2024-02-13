# 어떻게 확장해나갈지 생각해봐야한다.
# 글자에 대해 짝수, 홀수를 나눠 생각해야한다.

class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand(left : int, right : int) -> str:
            while s[left] == s[right]  and left >= 0 and right < len(s):
                left -= 1
                right += 1
                
            return s[left+1 : right] # 인덱스를 설정함으로써, 길이를 점차 늘려나갈 수 있게 구성
        
        if len(s) < 2 or s == s[::-1]: # 빠른 계산을 위해, 처음부터 팰린드롬이거나, 문자열의 길이가 1이하일 경우 그대로 반환
            return s
        
        for i in range(len(s) -1):
            result = max(result,expand(i,i+1), expand(i,i+2), key = len) # len을 key로 정함으로써 문자열 길이를 기준, 최대 길이의 문자열 반환
            
        return result
            
