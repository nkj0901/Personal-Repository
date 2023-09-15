import java.io.*;
import java.util.Arrays;

public class Main7682틱택톡_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();

            if(str.equals("end")) break;

            char[][] c = new char[3][3];
            int idx = 0;
            int X = 0;
            int O = 0;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    c[i][j] = str.charAt(idx++);
                    if(c[i][j] == 'X') X++;
                    else if(c[i][j] == 'O') O++;
                }
            }

            int x = 0;
            int o = 0;
            int x1 = 0;
            int o1 = 0;

            boolean xCheck = false;
            boolean oCheck = false;

            //가로, 세로 체크
            for(int i = 0; i < 3; i++){
                x = 0;
                o = 0;
                x1 = 0;
                o1 = 0;
                for(int j = 0; j < 3; j++){
                    if(c[i][j] == 'X') x++;
                    else if(c[i][j] == 'O') o++;

                    if(c[j][i] == 'X') x1++;
                    else if(c[j][i] == 'O') o1++;
                }
                if(x == 3 || x1 == 3) xCheck = true;
                else if(o == 3 || o1 == 3) oCheck = true;
            }

            x = 0;
            o = 0;
            x1 = 0;
            o1 = 0;
            //대각선
            for(int i = 0; i < 3; i++){
                if(c[i][i] == 'X') x++;
                else if(c[i][i] == 'O') o++;

                if(c[i][2-i] == 'X') x1++;
                else if(c[i][2-i] == 'O') o1++;
            }

            if(x == 3 || x1 == 3) xCheck = true;
            else if(o == 3 || o1 == 3) oCheck = true;

            boolean answer = false;

            if(xCheck && oCheck) answer = false;
            else {
                if(X+O == 9 && X == O+1 && !oCheck) answer = true;
                else if(xCheck && X == O+1) answer = true;
                else if(oCheck && X==O) answer = true;
            }
            bw.write(answer == true ? "valid\n" : "invalid\n");
        }//while
        bw.flush();
        bw.close();
        br.close();
    }
}
