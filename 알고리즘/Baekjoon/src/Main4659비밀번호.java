import java.io.*;

public class Main4659비밀번호 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();

            if( str.equals("end")) break;

            boolean mCheck = false;
            boolean aCheck = true;
            int m = 0;
            int j = 0;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if( c == 'a' || c == 'e' | c == 'i' | c == 'o' | c == 'u' ) {
                    mCheck = true;
                    m++;
                    j = 0;
                } else {
                    j++;
                    m = 0;
                }

                if(j >= 3 || m >= 3) {
                    aCheck = false;
                    break;
                }

                if(i > 0 && c == str.charAt(i-1)){
                    if(c != 'e' && c != 'o') {
                        aCheck = false;
                        break;
                    }
                }
            }
            if(aCheck && mCheck) System.out.println("<" + str + "> is acceptable.");
            else System.out.println("<" + str + "> is not acceptable.");
        }
    }
}
