import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3758KCPC {

    static int k;

    static class Team {
        int[] scores = new int[k+1]; //문제별 점수
        int submit = 0; //제출 횟수
        int last = 0; //마지막으로 제출한 시간
        int total = 0; //총점
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
            for(int tc = 0; tc < T; tc++){

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n+1];
            for(int i = 1; i <= n; i++){
                teams[i] = new Team();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                Team cur = teams[id];

                //마지막 제출한 시간 저장
                cur.last = i;
                //제출횟수 저장
                cur.submit++;

                if(cur.scores[number] < score) {
                    cur.total-=cur.scores[number];
                    cur.total+=score;
                    cur.scores[number] = score;
                }
            }
            int answer = 0;

            for(int i = 1; i <= n; i++){
                if(i == t) continue;
                if(teams[i].total > teams[t].total) answer++;
                else if(teams[i].total == teams[t].total){
                    if(teams[i].submit < teams[t].submit) answer++;
                    else if(teams[i].submit == teams[t].submit && teams[i].last < teams[t].last) answer++;
                }
            }
                System.out.println(answer+1);
        } //testcase
    }
}
