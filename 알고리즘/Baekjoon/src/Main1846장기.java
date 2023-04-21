import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1846장기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if( N == 3 ){
            System.out.println(-1);
        } else {
            System.out.println(N/2);
            for(int i = 1; i < N/2; i++){
                System.out.println(i);
            }
            for(int i = N/2+2; i <= N; i++){
                System.out.println(i);
            }
            System.out.println(N/2+1);
        }
    }
}
