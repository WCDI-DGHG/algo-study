import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();
        int index = 1;
        int currentNumber = 666;
        while (true) {
            if(input == index){
                break;
            }
            currentNumber++;
            if ((currentNumber + "").contains("666")) {
                index++;
            }
        }
        System.out.println(currentNumber);
    }
}