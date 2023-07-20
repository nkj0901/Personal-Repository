import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main2607비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] first = new int[26];
        int[] next;
        int gap;
        int answer = 0;
        String n;

        for(int i = 0; i < str.length(); i++){
            first[str.charAt(i)-65]++;
        }

        for(int i = 1; i < N; i++){
            n = br.readLine();
            next = new int[26];
            gap = 0;

            for(int j = 0; j < n.length(); j++){
                next[n.charAt(j)-65]++;
            }

            for(int z = 0; z < 26; z++){
                if(first[z] != next[z]) gap+=Math.abs(first[z]-next[z]);
            }
            if(str.length() == n.length() && gap < 3) answer++;
            else if(str.length() != n.length() && gap < 2) answer++;
        }

        System.out.println(answer);
    }
}
