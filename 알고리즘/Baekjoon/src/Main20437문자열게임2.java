import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main20437문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] count = new int[123]; //소문자 아스키 코드 97~122

            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i)]++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < str.length(); i++){
                char cur = str.charAt(i);

                if(count[cur] < K) continue;
                count[cur]--;

                    int cnt = 1;
                    for (int j = i+1; j < str.length(); j++) {
                        if (cur == str.charAt(j)) {
                            cnt++;
                            if (cnt == K) {
                                min = Math.min(min, j - i + 1);
                                max = Math.max(max, j - i + 1);
                                break;
                            }
                        }
                    }
            }
            if( min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        } //tc
    }
}
