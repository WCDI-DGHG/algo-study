import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private static PriorityQueue<Integer> APQ = new PriorityQueue<>();
    private static PriorityQueue<Integer> DPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("I")) {
                insert(Integer.parseInt(operations[i].split(" ")[1]));
                continue;
            }
            pop(Integer.parseInt(operations[i].split(" ")[1]));
        }

        if (!APQ.isEmpty()) {
            answer[0] = DPQ.peek();
            answer[1] = APQ.peek();
        }
        return answer;
    }

    private void insert(int num) {
        APQ.add(num);
        DPQ.add(num);
    }

    private void pop(int num) {
        if (num == 1 && !DPQ.isEmpty()) {
            APQ.remove(DPQ.poll());
        }
        if (num == -1 && !APQ.isEmpty()) {
            DPQ.remove(APQ.poll());
        }
    }
}