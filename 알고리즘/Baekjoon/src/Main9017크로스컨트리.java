import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main9017크로스컨트리 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] check = new int[201];
            int[] sum = new int[201];
            int[] five = new int[201];
            int[][] ranking = new int[N][2];

            for(int i = 0; i < N; i++){
                int n = Integer.parseInt(st.nextToken());
                ranking[i][0] = n;
                check[n]++;
            }
            int score = 1;
            for(int i = 0; i < N; i++){
                int n = ranking[i][0];
                if(check[n] == 6){
                    ranking[i][1] = score;
                    score++;
                }
            }

            for(int i = 1; i < 201; i++){
                if(check[i] == 6){
                    int cnt = 0;
                    int s = 0;
                    for(int j = 0; j < N; j++){
                        if(ranking[j][0] == i){
                            if(cnt != 4) {
                                s+=ranking[j][1];
                                cnt++;
                            } else {
                                five[i] = j+1;
                                break;
                            }
                        }
                    }
                    sum[i] = s;
                }
            }
            int min = Integer.MAX_VALUE;
            int team = 0;
            for(int i = 1; i < 201; i++){
                if(sum[i] == 0) continue;
                if(min > sum[i]){
                    min = sum[i];
                    team = i;
                } else if(min == sum[i]){
                    team = five[team] > five[i] ? i : team;
                }
            }
            System.out.println(team);
        }
    }
}

