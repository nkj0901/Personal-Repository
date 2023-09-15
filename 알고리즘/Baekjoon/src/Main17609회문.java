import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17609회문 {
    static char[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            c = br.readLine().toCharArray();
            int l = 0;
            int r = c.length - 1;

            if (check(l, r)) {
                sb.append(0 + "\n");
                continue;
            }
            if (change(l, r)) {
                sb.append(1 + "\n");
            } else {
                sb.append(2 + "\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean check(int l, int r) {
        while (l < r) {
            if (c[l] != c[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    private static boolean change(int l, int r) {
        while (l < r) {
            if (c[l] != c[r]) {
                boolean a=check(l+1,r);
                boolean b=check(l,r-1);
                if(a==false && b==false) return false;
                else return true;
            }
            l++;
            r--;
        }
        return true;
    }
}
