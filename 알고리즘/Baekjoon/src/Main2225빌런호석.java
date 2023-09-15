import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2225빌런호석 {
    static int answer, N, X, P, K;
    static int[][] arr = {
            {1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 1, 0}, //1
            {0, 1, 1, 1, 1, 0, 1}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 1, 0}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 1, 0}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}  //9
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //층수
        K = Integer.parseInt(st.nextToken()); //자릿수
        P = Integer.parseInt(st.nextToken()); //바꿀 수 있는 회수
        X = Integer.parseInt(st.nextToken()); //현재층수

        int cnt = 0;
        answer = 0;

        int[][] cur = new int[K][];

        cur = toArray(X);

        findAnswer(cur);
        System.out.println(answer);
    }

    public static void findAnswer(int[][] cur) {
        int[][] change;
        //1~N층으로 바꿨을 때 바뀐 스위치가 P개 이하이면 정답++
        for(int i = 1; i <= N; i++) {
            change = toArray(i);
            check(cur, change);
        }
    }

    public static int[][] toArray(int num){
        int[][] tmp = new int[K][];
        for(int i = K-1; i >= 0; i--){
            int n = num%(10);
            tmp[i] = arr[n];
            num= num/10;
        }
        return tmp;
    }

    public static void check(int[][] cur, int[][] change){
        int cnt = 0;
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < 7; j++){
                if(cur[i][j] != change[i][j]) cnt++;
            }
        }
        if(cnt <= P && cnt > 0) answer++;
    }
}
