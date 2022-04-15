/* 
Programmers
탐욕법(Gready)
조이스틱
Code_By_Goun
*/

def solution(name):
    answer = 0
    
    length = len(name)
    move = length - 1

    while name[move] == 'A' and move > 0:
        move -= 1

    for index, char in enumerate(name):
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)

        next = index + 1
        while next < length and name[next] == 'A':
            next += 1
            move = min(move, index * 2 + length - next)
            move = min(move, (length - next) * 2 + index)


    answer += move
    
    return answer