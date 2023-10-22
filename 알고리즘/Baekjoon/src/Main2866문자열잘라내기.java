import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2866문자열잘라내기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] c = new char[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                c[i][j] = str.charAt(j);
            }
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int r = R-1;
        int l = 0;
        while(l <= r) {
            int mid = (l+r)/2;
            set.clear();
            //같은지 다른지 확인하기
            for(int i = 0; i < C; i++) {
                for(int j = mid; j < R; j++) {
                    sb.append(c[j][i]);
                }
                set.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if(set.size() == C) l = mid + 1;
            else r= mid-1;
        }
        System.out.println(r);
    }
}
