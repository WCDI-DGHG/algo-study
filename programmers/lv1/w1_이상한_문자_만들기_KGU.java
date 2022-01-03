/* 
이상한 문자 만들기
https://programmers.co.kr/learn/courses/30/lessons/12930
Code_By_Goun
속도: 방법2와 방법4 유사, (<-앞의 방법이 더 빠름), 방법1과 방법3유사
*/

// 방법1: for문 1개만 사용
class Solution {
    public String solution(String s) {
        String answer = "";
        
        int len = s.length();
        int start = 0;
        char ch;
        for(int i = 0; i < len; i++, start++) {
            ch = s.charAt(i);
            if (ch == ' ') {
                start = -1;
             } else if (start % 2 == 0) {
                if (!(65 <= ch && ch <= 90)) {
                    ch = (char)((int)ch - 32);
                }
            } else {
                if (!(97 <= ch && ch <= 122)) {
                    ch = (char)((int)ch + 32);
                }
            }
            
            answer += ch;
        }
        
        return answer;
    }
}

// 방법2: 이중 for문
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ", -1);
        
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            int sLen = arr[i].length();
            for (int j = 0; j < sLen; j++) {
                char ch = arr[i].charAt(j);
                if (j % 2 == 0) {
                    if (!(65 <= ch && ch <= 90)) {
                        ch = (char)((int)ch - 32);
                    }
                } else {
                    if (!(97 <= ch && ch <= 122)) {
                        ch = (char)((int)ch + 32);
                    }
                }
                answer += ch;
            }
            
            if (i < (arrLen - 1)) {
                answer += ' ';
            }
        }
        
        return answer;
    }
}

// 방법3: for문 1개만 사용, 시작 전 모두 소문자로 만들어줌
class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        String[] arr = s.split(" ", -1);
        
        int len = s.length();
        int start = 0;
        char ch;
        for(int i = 0; i < len; i++, start++) {
            ch = s.charAt(i);
            if (ch == ' ') {
                start = -1;
             } else if (start % 2 == 0) {
                if (!(65 <= ch && ch <= 90)) {
                    ch = (char)((int)ch - 32);
                }
            }
            
            answer += ch;
        }
        
        return answer;
    }
}


// 방법4: 이중 for문, 시작 전 모두 소문자로 만들어줌
class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        String[] arr = s.split(" ", -1);
        
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            int sLen = arr[i].length();
            for (int j = 0; j < sLen; j++) {
                char ch = arr[i].charAt(j);
                if (j % 2 == 0) {
                    if (!(65 <= ch && ch <= 90)) {
                        ch = (char)((int)ch - 32);
                    }
                } 
                answer += ch;
            }
            
            if (i < (arrLen - 1)) {
                answer += ' ';
            }
        }
        
        return answer;
    }
}