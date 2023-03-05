import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main색종이만들기_dfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ansB = 0;
        ansW = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, N);
        System.out.println(ansW + "\n" + ansB);
    }

    static int[][] arr;
    static int ansB, ansW;

    private static void dfs(int r, int c, int n) {
        if( n == 1 ){
            if( arr[r][c] == 1 ) ansB++;
            else ansW++;
            return;
        }

        int B = 0;
        int W = 0;

        for(int i = r; i < r+n; i++){
            for(int j = c; j < c+n; j++){
                if( arr[i][j] == 0 ) W++;
                else B++;
            }
        }
        if(B == n*n) {
            ansB++;
        }
        else if(W == n*n) {
            ansW++;
        }
        else {
            dfs(r, c, n/2);
            dfs(r, c+n/2, n/2);
            dfs(r+n/2, c, n/2);
            dfs(r+n/2, c+n/2, n/2);
        }
    }
}
