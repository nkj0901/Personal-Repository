import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16967배열복원하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H+X][W+Y];
        for(int i = 0; i < H+X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W+Y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                arr[i+X][j+Y]-=arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
