import java.util.Scanner;

public class Main1789수들의합_그리디 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        int N = 0;
        long sum = 0;

        while(true){
            N++;
            sum+=N;
            if(sum == S) break;
            if(sum > S) {
                N--;
                break;
            }
        }
        System.out.println(N);
    }
}
