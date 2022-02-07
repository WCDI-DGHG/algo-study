import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        //1 = 1
        //2 3 4 5 6 7 = 6
        //8 9 10 11 12 13 14 15 16 17 18 19 = 12
        // 20~37 = 18
        int index = 1;
        int num = 6;
        int k = 1;
        while(k < A){
            k = k + num*index;
            index++;
        }
        System.out.println(index);
    }
}