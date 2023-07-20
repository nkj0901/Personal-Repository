import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19941햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        String str = br.readLine();
        char[] c = new char[N];

        for(int i = 0; i < N; i++){
            c[i] = str.charAt(i);
        }

        loop : for(int i = 0; i < N; i++){
            if( c[i] == 'H'){
                for(int j = -K; j <= K; j++){
                    int ni = i+j;
                    if(ni >= N || ni < 0) continue;
                    if(c[ni] == 'P') {
                        c[ni] = ' ';
                        answer++;
                        continue loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
