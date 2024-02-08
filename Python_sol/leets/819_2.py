import re
from collections import defaultdict
class Solution:
    def mostCommonWord(self, paragraph: str, banned: list[str]) -> str:
        paragraph = re.sub(r'[^\w]',' ',paragraph).lower().split()
        
        check = defaultdict(int)
        for word in paragraph:
            if not word in banned :
                check[word] += 1
                
        max_value = max(check, key = lambda x : check[x])
        return max_value
        
solution = Solution()
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
result = solution.mostCommonWord(paragraph, banned)
print(result)