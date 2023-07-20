import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        score = new int[N][9];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
             for(int j = 0; j < 9; j++){
                 score[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        arr = new int[8];
        tmp = new int[9];
        visited = new boolean[10];
        answer = 0;

        dfs(0);

        System.out.println(answer);
    }

    static int[] arr, tmp;
    static int[][] score;
    static boolean[] visited;
    static int answer, N;

    static void dfs(int n){

        if( n == 8 ) {
            getTmp();
            answer = Math.max(getScore(), answer);
            return;
        }

        for(int i = 2; i <= 9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[n] = i;
            dfs(n+1);
            visited[i] = false;
        }
    }

    static void getTmp(){
        for(int i = 0; i < 9; i++){
            if(i == 3) tmp[i] = 1;
            else if( i < 3) tmp[i] = arr[i];
            else tmp[i] = arr[i-1];
        }
    }

    static int getScore(){
        int cur = 0;
        int cnt = 0;

        for(int i = 0; i < N; i++){
            int out = 0;
            int[] ru = new int[4];

            while(true){
                int n = score[i][tmp[cur]-1];
                if(n == 0) out++;
                else {
                    ru[0] = 1;
                    for (int j = 3; j >= 0; j--) {
                        if (ru[j] == 1) {
                            ru[j] = 0;
                            if (j + n > 3) {
                                cnt++;
                            } else {
                                ru[j + n] = 1;
                            }
                        }
                    }
                }
                cur = (cur+1)%9;
                if(out == 3) break;
            }
        }
        return cnt;
    }
}

