import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1120문자열_브루트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int answer = 0;

        if(a.length() == b.length()){
            for(int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) answer++;
            }
        } else {
            answer = Integer.MAX_VALUE;
            for(int d = 0; d <= b.length()-a.length(); d++) {
                int cnt = 0;
                for(int i = d, cur = 0; i < d+a.length(); i++, cur++) {
                    if(a.charAt(cur) != b.charAt(i)) cnt++;
                }
                answer = Math.min(answer, cnt);
            }
        }
        System.out.println(answer);
    }
}
