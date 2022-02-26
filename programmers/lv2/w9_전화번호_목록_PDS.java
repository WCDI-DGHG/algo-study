import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        PriorityQueue<String> queue = new PriorityQueue<>(Arrays.asList(phone_book));
        while (queue.size() > 1) {
            String prevString = queue.poll();
            if (queue.peek().indexOf(prevString) == 0) {
                return false;
            }
        }
        return true;
    }
}