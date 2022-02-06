import java.util.*;
public class Solution {
    public int solution(int n) {
        String result = n + "";
        return result.chars().sum() - 48 * result.length();
    }
}