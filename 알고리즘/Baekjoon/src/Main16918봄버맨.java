import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16918봄버맨 {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int[][] boom;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

       boom = new int[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                boom[i][j] = str.charAt(j) == '.' ? -1 : 1;
            }
        }

        for(int n = 2; n <= N; n++) {
            plusTime();
            for(int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(boom[i][j] == 3) {
                        boom[i][j] = -1;
                        for(int d = 0; d < 4; d++) {
                            int nr = i+dr[d];
                            int nc = j+dc[d];
                            if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
                            if(boom[nr][nc] == 3) continue;
                            boom[nr][nc] = -1;
                        }
                    }
                }
            }
//            for(int[] a : boom) {
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(boom[i][j] >= 0) sb.append('O');
                else sb.append('.');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static void plusTime(){
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                boom[i][j]++;
            }
        }
    }
}
