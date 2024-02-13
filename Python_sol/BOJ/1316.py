import sys

input =sys.stdin.readline

n = int(input())
words =[]
for _ in range(n):
    words.append(input().strip())

group_word =0
for word in words:
    for i in range(len(word)):
        if i != len(word) -1 :
            if word[i] == word[i+1]:
                continue
            elif word[i] in word[i+1:]:
                break
        else:
            group_word +=1

print(group_word)

