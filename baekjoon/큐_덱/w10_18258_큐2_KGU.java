/*
BAEKJOON
큐_덱
18258번_큐2
Code_By_Goun
*/

import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new LinkedList<>();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int result = -10;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String order = st.nextToken();
            switch(order) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    continue;

                case "pop":
                    if (!queue.isEmpty())
                        result = queue.poll();
                    else 
                        result = -1;
                    break;

                case "size":
                    result = queue.size();
                    break;

                case "empty":
                    result = queue.isEmpty() ? 1:0;
                    break;

                case "front":
                    result = queue.isEmpty() ? -1:queue.peek();
                    break;

                case "back":
                    result = queue.isEmpty() ? -1:queue.peekLast();
                    break;
            } // end switch
            bw.write(result+"\n");
        }// end for

        bw.flush();
        bw.close();
    }// end main
}// end class
