import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20125쿠키의신체측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        int hr = 0;
        int hc = 0;
        int la = 0;
        int ra = 0;
        int we = 0;
        int ll = 0;
        int rl = 0;

        loop: for(int i = 0; i < N; i++){
            str = br.readLine();
            for(int j = 0; j < N; j++){
                //머리 발견
                if(str.charAt(j)=='*'){
                    //심장 위치 저장
                    hr = i+1;
                    hc = j;

                    //팔길이 구하기
                    str = br.readLine();
                    for(int c = 0; c < N; c++){
                        if(str.charAt(c)=='*'){
                            if(c < hc) la++;
                            else if(c > hc) ra++;
                        }
                    }

                    //허리길이와 다리길이
                    for(int w = hr+1; w < N; w++){
                        str = br.readLine();
                        for(int c = 0; c < N; c++){
                            if(str.charAt(c)=='*'){
                                if(c == hc) we++;
                                else if (c < hc) ll++;
                                else rl++;
                            }
                        }
                    }

                    System.out.println(++hr + " " + ++hc);
                    System.out.println(la + " " + ra + " " + we + " " + ll + " " + rl);
                    break loop;
                }
            }
        }
    }
}
