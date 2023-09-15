import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2138전구와스위치_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String cur = br.readLine();
        char[] target = br.readLine().toCharArray();

        char[] first = cur.toCharArray();
        char[] second = cur.toCharArray();


        //맨 앞에 것을 바꿨을 때
        change(first, 0);

        int answer = Math.min(count(first, target, 1),count(second, target, 0));
        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    static int[] ni = {-1, 0, 1};

    public static int count(char[] c, char[] target, int cnt){
        for(int i = 1; i < c.length; i++){
            if(c[i-1] != target[i-1]) {
                change(c, i); cnt++;
            }
        }
        if(target[target.length-1] != c[c.length-1]) cnt = Integer.MAX_VALUE;
        return cnt;
    }

    public static void change(char[] c, int num){
        for(int i = 0; i < 3; i++) {
            int idx = num+ni[i];
            if(idx < 0 || idx >= c.length) continue;
            c[idx] = c[idx] == '0' ? '1' : '0';
        }
    }
}
