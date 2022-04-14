/*
BAEKJOON
백트래킹
15650번_N과 M(2)
PYTHON
Code_By_Goun
*/

def dfs(start):
    if len(v) == M:
        print(' '.join(map(str, v)))
        return

    for index in range(start, N + 1):
        if not visited[index]:
            v.append(index)
            visited[index] = True
            dfs(index + 1)
            visited[index] = False
            v.pop()


N, M = map(int, input().split())

visited = [False] * (N+1)
v = []

dfs(1)