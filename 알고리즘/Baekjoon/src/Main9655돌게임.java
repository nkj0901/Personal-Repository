import java.sql.SQLOutput;
import java.util.Scanner;

public class Main9655돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //짝수라면
        if(N%2 == 0) System.out.println("CY");
        if(N%2 != 0) System.out.println("SK");
    }
}
