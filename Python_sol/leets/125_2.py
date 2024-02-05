# https://leetcode.com/problems/valid-palindrome/
import re
class Soultion:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-z0-9]','',s)
        
        return s == s[::-1]