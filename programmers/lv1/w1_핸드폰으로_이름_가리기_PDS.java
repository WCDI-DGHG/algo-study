class Solution {
    public String solution(String phone_number) {
    char[] cArr = phone_number.toCharArray();
    for (int i = 0; i < cArr.length - 4; i++) {
      cArr[i] = '*';

    }
    return String.valueOf(cArr);
  }
}