import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int grade = s.nextInt();

        String res = grade >= 90 ? "A" : (grade >= 80 ? "B" : grade >= 70 ? "C" : (grade >= 60 ? "D" : "F"));
        System.out.println(res);

    }
}