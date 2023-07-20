import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1515수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int base = 1;
        int pt = 0;

        loop: while(true){
            String tmp = String.valueOf(base);
            for(int i = 0; i < tmp.length(); i++){
                if(str.charAt(pt) == tmp.charAt(i)) pt++;
                if(pt == str.length()) break loop;
            }
            base++;
        }
        System.out.println(base);
    }
}
