## Problem 23: Balanced Nested Architecture
# Difficulty: Easy
# Pattern 23: Validation Stack (Nested structure parsing)
# Problem Statement:
# You are building a custom configuration compiler that parses code scope tokens. You are given a string s 
# containing just the characters '(', ')', '{', '}', '[' and ']'.
# Determine if the input string is valid. An input string is valid if:

#    1. Open brackets must be closed by the same type of brackets.
#    2. Open brackets must be closed in the correct nested order.
#    3. Every close bracket has a corresponding open bracket of the same type.

# Example 1:

# * Input: s = "()"
# * Output: true

# Example 2:

# * Input: s = "()[]{}"
# * Output: true

# Example 3:

# * Input: s = "(]"
# * Output: false

# Constraints:

# * 1 <= s.length <= 10⁴
# * s consists of parentheses only.


def is_valid(s:str) -> bool:
    stack = []
    for c in s:
        if c in ['[','(','{']:
            stack.append(c)
        elif stack:
            if c is ']' and stack.pop() is '[':
                continue
            elif c is ')' and stack.pop() is '(':
                continue
            elif c is '}' and stack.pop() is '{':
                continue
            else:
                return False
        else:
            return False

    return not stack

print(is_valid('()[]'))
print(is_valid(')[]'))
print(is_valid('[())[]'))


def is_valid_2(s:str) ->bool:
    bracket_map = {']':'[', '}':'{',')':'('}

    open_bracket_set = set(bracket_map.values())
    closing_bracket_set = set(bracket_map.keys())
    stack = []
    for c in s:
        if c in open_bracket_set:
            stack.append(c)
        elif c in closing_bracket_set:
            if stack and bracket_map.get(c) == stack.pop():
                continue
            else:
                return False
        else:
            return False
    return not len(stack)



print(is_valid_2('()[]'))
print(is_valid_2(')[]'))
print(is_valid_2('[())[]'))