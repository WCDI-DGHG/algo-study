import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println(new Scanner(System.in)
                           .nextLine()
                           .replaceAll("c=","C").replaceAll("c-","V")
                           .replaceAll("dz=","Z").replaceAll("d-","D")
                           .replaceAll("lj","L").replaceAll("nj","N")
                           .replaceAll("s=","S").replaceAll("z=","X").length());
    }
}