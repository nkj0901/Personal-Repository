import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111마인크래프트구현{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int height = 0;
        int time = Integer.MAX_VALUE;

        int[][] map = new int[n][m];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                sum+=map[i][j];
            }
        }

        for(int i = sum/(n*m); i <= max; i++){
            int tmp = func(i, map, b);
            if(time >= tmp){
                height = i;
                time = tmp;
            }
        }
        System.out.println(time + " " + height);

    }
    static int n, m;

    static int func(int num, int[][] map, int b) {
        int time = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] > num) {
                    time+=(map[i][j]-num)*2;
                    b+=map[i][j]-num;
                }
                else if(map[i][j] < num) {
                    time+=num-map[i][j];
                    b-=num-map[i][j];
                }
            }
        }
        return time = b >= 0 ? time : Integer.MAX_VALUE;
    }
}
