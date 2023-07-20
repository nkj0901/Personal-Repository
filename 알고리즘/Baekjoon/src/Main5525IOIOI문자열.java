import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5525IOIOI문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int answer = 0;
        int cnt = 0;
        for(int i = 1; i < m-1;){
            if(s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == n){
                    if(s.charAt(i-(cnt*2-1))=='I'){
                        answer++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }
        System.out.println(answer);
    }
}
