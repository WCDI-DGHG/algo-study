/* 
Programmers
정렬
K번째수
Code_By_Goun
*/

def solution(array, commands):
    answer = []
    
    for command in commands:
        i, j, k = command
        sort_arr = array[i - 1: j]
        sort_arr.sort()
        answer.append(sort_arr[k - 1])
        
    return answer
