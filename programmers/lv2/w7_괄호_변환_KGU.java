/* 
괄호 변환
프로그래머스_재귀함수
Code_By_Goun
*/

import java.util.Stack;

class Solution {
    public String solution(String p) {
        StringBuffer answer = new StringBuffer();
        Stack stack = new Stack();
        StringBuffer u = new StringBuffer();
        StringBuffer v = new StringBuffer();
     
        // 입력이 빈 문자열인 경우
        if (p.equals("")) return answer.toString();
        
        // 1. 두 문자열 u, v로 분리(균형잡힌 괄호 문자열)
        for (int i = 0; i < p.length(); i++) {
        	String str = p.charAt(i) + "";
        	if (stack.isEmpty()) {
        		stack.push(str);
        		if(i!=0) {
        			u.append(p.substring(0, i));
        			v.append(p.substring(i));
        			stack.clear();
        			break;
        		}
        	}
        	else if (str.equals(stack.peek())) {
        		stack.push(str);
        	} else {
        		stack.pop();
        	}
        }
        
        if (u.length() == 0) {
        	u.append(p);
        }
        
        System.out.println("u: " + u);
        System.out.println("v: " + v);

        // u가 올바른 괄호 문자열인지 확인
        if (u.charAt(0) == '(') {
        	answer.append(u);
        	answer.append(solution(v.toString()));
        } else {
        	answer.append('(');
        	answer.append(solution(v.toString()));
        	answer.append(')');
        	u.deleteCharAt(1);
        	u.deleteCharAt(u.length() - 1);

        	for (int i = 0; i < u.length(); i++) {
        		answer.append((u.charAt(i) == '(') ?  ')' : '(');
        	}
        }
        return answer.toString();
    }
}

public class Main{
	public static void main(String[] args) {
		Solution s = new Solution();
		String p = "))()))((((";
		System.out.println(s.solution(p) + "");
	}
}
