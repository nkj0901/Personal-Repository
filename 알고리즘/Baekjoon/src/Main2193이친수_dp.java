import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2193이친수_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //0으로 끝난 것
        long[] zero = new long[91];
        //1으로 끝난 것
        long[] one = new long[91];

        one[1] = 1;
        zero[2] = 1;

        for(int i = 3; i <= N; i++) {
            zero[i] = one[i-1] + zero[i-1];
            one[i] = zero[i-1];
        }

        System.out.println(zero[N] + one[N]);
    }
}
