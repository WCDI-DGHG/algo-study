import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        //StringBuilder 안쓰니까 시간초과뜸
        StringBuilder sb = new StringBuilder();

        MyQueue queue = new MyQueue(len);
        for (int i = 0; i < len; i++) {
            String input = br.readLine();
            if (input.length() >= 6) {
                queue.push(Integer.parseInt(input.split(" ")[1]));
                continue;
            }
            if (input.equals("pop")) {
                sb.append(queue.pop()).append("\n");
                continue;
            }
            if (input.equals("size")) {
                sb.append(queue.getCurrentSize()).append("\n");
                continue;
            }
            if (input.equals("empty")) {
                sb.append(queue.isEmpty()).append("\n");
                continue;
            }
            if(input.equals("front")){
                sb.append(queue.getFront()).append("\n");
                continue;
            }
            //top
            sb.append(queue.getRear()).append("\n");
        }
        System.out.println(sb.toString());
    }
}

class MyQueue {
    private int[] list;
    private int size;
    private int rear;
    private int front;

    public MyQueue(int size) {
        this.size = size;
        this.list = new int[size];
        this.rear = 0;
        this.front = 0;
    }

    public int isEmpty() {
        if (rear == front) {
            rear = 0;
            front = 0;
            return 1;
        }
        return 0;
    }

    public void push(int val) {
        list[rear++] = val;
    }

    public int pop() {
        if (isEmpty() != 1) {
            return list[front++];
        }
        return -1;
    }

    public int getFront() {
        if (isEmpty() != 1) {
            return list[front];
        }
        return -1;
    }
    public int getRear() {
        if(isEmpty() != 1){
            return list[rear-1];
        }
        return -1;
    }

    public int getCurrentSize() {
        return rear - front;
    }
}
