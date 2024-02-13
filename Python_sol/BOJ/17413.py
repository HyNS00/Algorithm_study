# https://www.acmicpc.net/problem/17413
def reverse_string(string):
    reversed_string = ''
    stack = []
    tag = False

    for char in string :
        if char == '<':
            tag = True
            while stack:
                reversed_string += stack.pop()
            reversed_string += char

        elif char == '>':
            tag = False
            reversed_string += char
        elif tag :
            reversed_string += char
        elif char  == ' ':
            while stack :
                reversed_string += stack.pop()
            reversed_string += char
        
        else :
            stack.append(char)

    while stack:
        reversed_string += stack.pop()

    return reversed_string

input_string = input()
result = reverse_string(input_string)
print(result)       
            