import java.util.*;
import java.io.*;

public class Main20310타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str = br.readLine();

        int zero = 0;
        int one = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') one++;
            else zero++;
        }
        sb.append(str);

        zero/=2; one/=2;

        //1없애기
        for(int i = 0; i < sb.length(); i++){
            if(one <= 0) break;
            if(sb.charAt(i) == '1') {
                one--;
                sb.delete(i, i+1);
                i--;
            }
        }

        sb.reverse();

        //0없애기
        for(int i = 0; i < sb.length(); i++){
            if (zero <= 0 ) break;
            if( sb.charAt(i) == '0') {
                zero--;
                sb.delete(i, i+1);
                i--;
            }
        }
        System.out.println(sb.reverse());
    }
}
