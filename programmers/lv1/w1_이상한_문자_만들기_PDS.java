package step10_java8;
class Solution {
    public String solution(String s) {
        char[] cArr = s.toLowerCase().toCharArray();
        int ind = 0;
        for(int i = 0; i < cArr.length; i ++){
            if(cArr[i] == ' '){
                ind = 0;
                continue;
            }
            if(ind == 0){
                cArr[i]  -= 32;
            }
            ind = (ind + 1) % 2;
        }
        String result = String.valueOf(cArr);
        return result;
    }
}