/*
BAEKJOON
다이나믹 프로그래밍
15489번_파스칼 삼각형
Code_By_Goun
*/

def main():
    R, C, W = map(int, input().split())
    dp = [[1] * i for i in range(1, 32)]

    for n in range(2, 31):
        for m in range(1, len(dp[n]) - 1):
            dp[n][m] = dp[n - 1][m - 1] + dp[n - 1][m]

    sum = 0
    for n in range(R - 1, R + W - 1):
        for m in range(C - 1, C + (n - R) + 1):
            sum += dp[n][m]

    print(sum)


## 메인 함수 호출 ##
if __name__ == "__main__":
    main()
