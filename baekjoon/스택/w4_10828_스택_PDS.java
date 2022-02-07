package e01.dto;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        MyStack stack = new MyStack(len);
        for (int i = 0; i < len; i++) {
            String input = br.readLine();
            if (input.length() >= 6) {
                stack.push(Integer.parseInt(input.split(" ")[1]));
                continue;
            }
            if (input.equals("pop")) {
                System.out.println(stack.pop());
                continue;
            }
            if (input.equals("size")) {
                System.out.println(stack.getSize());
                continue;
            }
            if(input.equals("empty")){
                System.out.println(stack.isEmpty());
                continue;
            }
            //top
            System.out.println(stack.peek());
        }
    }
}

class MyStack {
    private int[] list;
    private int size;
    private int top;

    public MyStack(int size) {
        this.size = size;
        list = new int[size];
        top = -1;
    }

    // isEmpty
    public int isEmpty() {
        return (top == -1) ? 1 : 0;
    }
    // isFull
    // 필요없다. 꽉 찰일 없다.

    // push
    public void push(int data) {
        list[++top] = data;
    }

    // pop
    public int pop() {
        if (isEmpty() == 1) {
            return -1;
        }
        return list[top--];
    }
    // top
    public int peek() {
        return (top!=-1) ? list[top]: -1;
    }
    // size
    public int getSize() {
        return top+1;
    }
}
