/*
BAEKJOON
DFS와 BFS
11558번_The Game of Death
PYTHON
Code_By_Goun
*/

count = int(input())

for _ in range(count):
    T = int(input())
    visited = [False] * (T + 1)
    stack = []

    visited[0] = True
    for _ in range(T):
        p = int(input())

        if not visited[T] and not visited[p]:
            stack.append(p)
            visited[p] = True
        else:
            break

    if visited[T]:
        print(len(stack))
    else:
        print("0")