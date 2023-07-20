import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main25757임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int answer = 0;

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            set.add(str);
        }

            switch(game){
                case 'Y':
                    answer = set.size();
                    break;
                case 'F':
                    answer = set.size()/2;
                    break;
                case 'O':
                    answer = set.size()/3;
            }

        System.out.println(answer);
    }
}
