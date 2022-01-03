import java.util.*;

class Solution {
    public String solution(String s) {
        char[] C = s.toCharArray();
        Arrays.sort(C);
        return new StringBuilder(String.valueOf(C)).reverse().toString();
    }
}