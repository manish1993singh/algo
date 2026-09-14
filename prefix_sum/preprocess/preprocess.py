class Request_log:
    def __init__(self):
        self.processed_log = [0]

    def submit_log(self, logs):
        self.processed_log = [0]
        for count in logs:
            self.processed_log.append(self.processed_log[-1] + count)

    def read_request_count(self, left, right):
        return self.processed_log[right + 1] - self.processed_log[left]

    def read_request_counts(self, queries):
        return [self.read_request_count(left, right) for left, right in queries]


r = Request_log()
r.submit_log([5, 2, 8, 1, 9])
print(r.read_request_counts([[1, 3], [0, 4], [2, 2]]))