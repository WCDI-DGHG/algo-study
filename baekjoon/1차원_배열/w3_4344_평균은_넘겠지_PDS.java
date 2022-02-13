// 풀이1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr;

        int testcase = s.nextInt();

        for(int i = 0 ; i < testcase ; i++) {

            int N = s.nextInt();	
            arr = new int[N];

            double sum = 0;	
           
            for(int j = 0 ; j < N ; j++) {
                int val = s.nextInt();	
                arr[j] = val;
                sum += val;
            }

            double mean = (sum / N) ;
            double count = 0; 

            for(int j = 0 ; j < N ; j++) {
                if(arr[j] > mean) {
                    count++;
                }
            }

            System.out.printf("%.3f%%\n",(count/N)*100);


        }
        s.close();
    }

}




// 풀이2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        for (int i = 0; i < len; i++) {
            List<Double> list =
                    Arrays.asList(br.readLine().split(" "))
                            .stream()
                            .map(v -> Double.parseDouble(v))
                            .collect(Collectors.toList());
            list.remove(0);
            double result =
                    list.stream()
                            .filter(w -> w > list.stream().mapToDouble(v -> v).average().getAsDouble())
                            .count() / (double) list.size();
            // ??????
            System.out.printf("%.3f%%\n", result * 100);
        }
    }
}