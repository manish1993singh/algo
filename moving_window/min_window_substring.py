from collections import Counter

def get_min_window(s, t):
    expected = Counter(t)

    left = 0
    right = 1
    window = Counter(s[left:right])
    # {s[left]:1}

    result = ""
    while right < len(s):
        window[s[right]] = window.get(s[right]) +1 if window.get(s[right]) else 1

        if helper_match(expected, window):
            result = result if len(s[left:right+1]) > len(result) > 0 else s[left:right+1]

            left += 1
            window[s[left-1]] -= 1
            while True:
                if s[left] in expected:
                    break
                left += 1
                window[s[left-1]] -= 1

        right += 1
    print(result)
    return result

def helper_match(expected, window):
    for key, value in expected.items():
        if window[key] < value:
            return False
    return True

print(get_min_window("adobecodebanc", "abc"))
