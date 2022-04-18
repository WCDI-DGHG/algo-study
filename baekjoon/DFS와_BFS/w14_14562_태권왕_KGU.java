/*
BAEKJOON
DFS와 BFS
14562번_태권왕
PYTHON
Code_By_Goun
*/

# deque 라이브러리
from collections import deque

def main():
    count = int(input())

    result = ""
    for _ in range(count):
        s, t = map(int, input().split())
        result += str(bfs(s, t)) + "\n"

    print(result)

def bfs(s, t):
    queue = deque()
    queue.append((s, t, 0))

    while queue:
        s, t, c = queue.popleft()
        if s < t:
            queue.append((s * 2, t + 3, c + 1))
            queue.append((s + 1, t, c + 1))
        elif s == t:
            return c

## 메인 함수 호출 ##
if __name__ == "__main__":
    main()
