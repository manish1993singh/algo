def get_time(arr, cooldown_time):
    task_freq = [0] * 26
    for c in arr:
        task_freq[ord(c) - ord('A')] += 1

    max_frequency_task = max(task_freq)
    m = task_freq.count(max_frequency_task)

    total_time = (max_frequency_task - 1)*(cooldown_time+1)+m
    return max(len(arr), total_time)

print(get_time(['A','A','A','B','B','B'], 2))