import java.util.stream.Collectors;

public class Solution {

    public String solution(String p) {
        return doJaeGui(p);
    }
    private String doJaeGui(String p) {
        StringBuilder sb = new StringBuilder();
        if ("".equals(p)) {
            return "";
        }
        String[] seperatedP = seperateBalanceString(p);
        if (!isGoodGwalho(seperatedP[0])) {
            sb.append("(");
            sb.append(doJaeGui(seperatedP[1]));
            sb.append(")");
            sb.append(reverseGwalho(seperatedP[0].substring(1, seperatedP[0].length() - 1)));
        } else {
            sb.append(seperatedP[0]);
            sb.append(doJaeGui(seperatedP[1]));
        }
        return sb.toString();
    }

    private String[] seperateBalanceString(String p) {
        int left = 0;
        int right = 0;
        int index = -1;
        while (true) {
            index++;
            if (index != 0 && left == right) {
                break;
            }
            if (p.charAt(index) == '(') {
                left++;
                continue;
            }
            right++;
        }
        return new String[]{p.substring(0, left + right), p.substring(left + right)};
    }

    private String reverseGwalho(String p) {
        return p.chars().mapToObj(v -> {
            if (v == ')') {
                return '(';
            }
            return ')';
        }).map(String::valueOf).collect(Collectors.joining());
    }

    private boolean isGoodGwalho(String p) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (right > left) {
                return false;
            }
            if (p.charAt(i) == '(') {
                left++;
                continue;
            }
            right++;
        }
        return left == right;
    }
}