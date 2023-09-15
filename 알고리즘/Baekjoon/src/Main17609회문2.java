import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17609회문2 {
    static char[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++) {
            c = br.readLine().toCharArray();

            int l = 0;
            int r = c.length-1;

            if(check(l, r)) {
                sb.append("0\n");
                continue;
            }

            while(l < r){
                if(c[l] != c[r])  {
                    if (check(l+1, r) || check(l, r-1)) sb.append("1\n");
                    else sb.append("2\n");
                    break;
                }
                l++;
                r--;
            }
        }
        System.out.println(sb);
    }

    private static boolean check(int l, int r){
        while(l < r){
            if(c[l] != c[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
