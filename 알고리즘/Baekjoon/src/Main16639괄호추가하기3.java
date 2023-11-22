import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main16639괄호추가하기3 {
    static int[][] max, min;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        max = new int[N][N];
        min = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < N; i+=2){
            max[i][i] = str.charAt(i)-'0';
            min[i][i] = str.charAt(i)-'0';
        }
        int[] candidates = new int[4];

        //몇개씩 묶을 것인지
        for(int k = 2; k < N; k+=2 ) {
            //숫자 뭐부터 묶을 건지
            for(int i = 0; i < N-k; i+=2) {
                //0부터 i+k까지 계산해 보면서 만들어지는 제일 작은 수, 큰 수 구하기
                for(int j = i+1; j < i+k; j+=2) {
                    char ch = str.charAt(j);
                    candidates[0] = calculate(max[i][j-1], max[j+1][i+k], ch);
                    candidates[1] = calculate(max[i][j-1], min[j+1][i+k], ch);
                    candidates[2] = calculate(min[i][j-1], max[j+1][i+k], ch);
                    candidates[3] = calculate(min[i][j-1], min[j+1][i+k], ch);

                    Arrays.sort(candidates);
                    max[i][i+k] = Math.max(max[i][i+k], candidates[3]);
                    min[i][i+k] = Math.min(min[i][i+k], candidates[0]);
                }
            }
        }
        System.out.println(max[0][N-1]);
    }
    static int calculate(int a, int b, char c){
        switch(c){
            case '*' :
                return a*b;
            case '-' :
                return a-b;
            default :
                return a+b;
        }
    }
}
