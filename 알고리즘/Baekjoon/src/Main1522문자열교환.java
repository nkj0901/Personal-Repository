import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1522문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] chars = str.toCharArray();

        int A = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                A++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            int cnt = 0;
            for(int j = 0; j < A; j++){
                if(cnt > ans) break;
                if (chars[(i+j)%chars.length] == 'b') {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}
