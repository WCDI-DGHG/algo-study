/*
BAEKJOON
15596번_정수 N개의 합
Code_By_Goun
*/

public class Test {
    long sum(int[] a) {
        long answer = 0;
        
        for(int index = 0; index<a.length; index++) {
            answer += a[index];
        }
        
        return answer;
    }
}
