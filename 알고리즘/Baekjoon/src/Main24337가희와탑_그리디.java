import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main24337가희와탑_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a+b > N+1) {
            System.out.print(-1);
            return;
        }

        List<Integer> list = new ArrayList<>();

        //왼쪽 채우기
        for(int i = 1; i < a; i++) {
            list.add(i);
        }
        list.add(Math.max(a, b));

        //오른쪽 채우기
        for(int i = b-1; i >= 1; i--) {
           list.add(i);
        }

        //1을 앞으로 다 빼기
        while(list.size() != N) {
            list.add(1, 1);
        }

        for(int i = 0; i < N; i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb);
    }
}
