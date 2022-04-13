/*
BAEKJOON
백트래킹
15649번_N과 M(1)
PYTHON
Code_By_Goun
*/


def dfs():
    if len(v) == M:
        print(' '.join(map(str, v)))
        return

    for index in range(1, N + 1):
        if not visited[index]:
            v.append(index)
            visited[index] = True
            dfs()
            visited[index] = False
            v.pop()


N, M = map(int, input().split())

visited = [False] * (N+1)
v = []

dfs()