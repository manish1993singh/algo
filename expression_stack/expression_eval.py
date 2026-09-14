## Problem 24: Enterprise Arithmetic Pipeline
# Difficulty: Hard
# Pattern 24: Expression Stack (Expression Evaluation)
# Problem Statement:
# You are implementing a mathematical expression evaluator engine for an entry-level spreadsheet software. 
# Given a string s representing a valid mathematical expression, evaluate this expression and return its result.
# The input string s contains only non-negative integers, +, -, *, / operators, and empty spaces. The integer division should truncate toward zero (e.g., in Python 3 // 2 = 1, and -3 // 2 = -1, so truncation toward zero means using int(a / b)).
# You may assume that the given expression is always valid. Do not use your language's built-in eval() function.
# Example 1:

# * Input: s = "3+2*2"
# * Output: 7

# Example 2:

# * Input: s = " 3/2 "
# * Output: 1

# Example 3:

# * Input: s = " 3+5 / 2 "
# * Output: 5

# Constraints:

# * 1 <= s.length <= 3 * 10⁵
# * s consists of integers, operators, and spaces.
# * All the integers in the expression are non-negative integers in the range [0, 2³¹ - 1].


def eval(expression_str: str) -> int:
    stack = []
    operators = {'+', '-', '*', '/'}
    
    # Parse and build stack
    for c in expression_str:
        if c.isspace():
            continue
        if c in operators:
            stack.append(c)
        else:  # c.isdigit()
            if stack and stack[-1][-1].isdigit():
                stack.append(stack.pop() + c)
            else:
                stack.append(c)

    # Helper function to process operators
    def process_operator(op, operation):
        indices = [i for i, v in enumerate(stack) if v == op]
        for oper_idx in indices[::-1]:
            left_over = stack[oper_idx + 2:]
            stack[:] = stack[:oper_idx + 2]
            right_operand = int(stack.pop())
            stack.pop()  # remove operator
            left_operand = int(stack.pop())
            result = operation(left_operand, right_operand)
            stack.append(str(result))
            stack.extend(left_over)
    
    # Process operators in order of precedence
    process_operator('/', lambda a, b: int(a / b))
    process_operator('*', lambda a, b: a * b)
    process_operator('+', lambda a, b: a + b)
    process_operator('-', lambda a, b: a - b)
    
    return int(stack[-1])
print(eval('1*2  + 189'))

# the code works but it is not its best version

def calculate(s: str) -> int:
    if not s:
        return 0
        
    stack = []
    current_number = 0
    current_operator = '+'
    operators = {'+', '-', '*', '/'}
    
    for i, char in enumerate(s):
        if char.isdigit():
            current_number = current_number * 10 + int(char)
            
        # Evaluate when encountering an operator OR at the very last character
        if char in operators or i == len(s) - 1:
            if current_operator == '+':
                stack.append(current_number)
            elif current_operator == '-':
                stack.append(-current_number)
            elif current_operator == '*':
                stack.append(stack.pop() * current_number)
            elif current_operator == '/':
                # int() handles truncation toward zero correctly for negative values
                stack.append(int(stack.pop() / current_number))
                
            # Update the operator context and reset current number tracking
            current_operator = char
            current_number = 0
            
    return sum(stack)

# Verification
print(calculate("3+2*2"))     # Output: 7
# print(calculate(" 3/2 "))     # Output: 1
# print(calculate(" 3+5 / 2 ")) # Output: 5
