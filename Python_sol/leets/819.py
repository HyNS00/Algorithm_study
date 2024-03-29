import re
class Solution:
    def mostCommonWord(self, paragraph: str, banned: list[str]) -> str:
        paragraph = re.split("[!?',;. ]", paragraph.lower())
        
        dic = dict()
        for p in paragraph:
            if p in dic: dic[p] += 1
            else: dic[p] = 1
        dic = sorted(dic.items(), key=lambda x:-x[1])
        for d in dic:
            if d[0] not in banned and d[0] != '':
                return d[0]
            
solution = Solution()
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
result = solution.mostCommonWord(paragraph, banned)
print(result)