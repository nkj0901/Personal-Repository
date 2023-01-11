import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17615볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int min = Integer.MAX_VALUE;
        boolean check = false;
        int cnt = 0;

        //R을 왼쪽으로
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'B'){
                check = true;
            }
            if(check){
                if(str.charAt(i) == 'R'){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);

        //B를 왼쪽으로
        check = false;
        cnt = 0;
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'R'){
                check = true;
            }
            if(check){
                if(str.charAt(i) == 'B'){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);

        //R을 오른쪽으로
        check = false;
        cnt = 0;
        for(int i = N-1; i >= 0; i--){
            if(str.charAt(i) == 'B'){
                check = true;
            }
            if(check){
                if(str.charAt(i) == 'R'){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);

        //B을 오른쪽으로
        check = false;
        cnt = 0;
        for(int i = N-1; i >= 0; i--){
            if(str.charAt(i) == 'R'){
                check = true;
            }
            if(check){
                if(str.charAt(i) == 'B'){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);

        System.out.println(min);
    }
}
