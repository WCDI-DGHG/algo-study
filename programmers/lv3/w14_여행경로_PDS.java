import java.util.*;

class Solution {

    private static Map<String, PriorityQueue<Air>> map = new HashMap<>();
    private static String[] resultArray = null;
    private static List<String[]> resultList = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (map.get(tickets[i][0]) == null) {
                map.put(tickets[i][0], new PriorityQueue<>((o1, o2) -> o1.ticket.compareTo(o2.ticket)));
            }
            map.get(tickets[i][0]).offer(new Air(tickets[i][1]));
        }

        resultArray = new String[tickets.length + 1];
        dfs("ICN", 0);
        Collections.sort(resultList, (o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (!o1[i].equals(o2[i])) {
                    return o1[i].compareTo(o2[i]);
                }
            }
            return 1;
        });
        return resultList.get(0);
    }

    private static void dfs(String start, int idx) {
        resultArray[idx] = start;

        if (idx == resultArray.length - 1) {
            resultList.add(resultArray.clone());
        }

        PriorityQueue<Air> priorityQueue = map.get(start);
        if (priorityQueue == null) {
            return;
        }
        Iterator<Air> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            Air current = iterator.next();
            if (current.visited) {
                continue;
            }

            current.visited = true;
            dfs(current.ticket, idx + 1);
            current.visited = false;
        }

    }
}

class Air {
    String ticket;
    boolean visited;

    public Air(String ticket) {
        this.ticket = ticket;
        this.visited = false;
    }
}