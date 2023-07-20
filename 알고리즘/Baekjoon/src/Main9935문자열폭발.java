import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9935문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String b = br.readLine();

        StringBuilder stack = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == b.charAt(b.length()-1)) {
                if(b.length() == 1) continue;
                tmp.append(c);
                for (int j = b.length() - 2; j >= 0; j--) {

                    if(stack.length() == 0) {
                        tmp.reverse();
                        stack.append(tmp);
                        tmp.setLength(0);
                        break;
                    }

                    char c2 = stack.charAt(stack.length() - 1);

                    if (c2 == b.charAt(j)) {
                        tmp.append(c2);
                        stack.deleteCharAt(stack.length()-1);
                    } else {
                        tmp.reverse();
                        stack.append(tmp);
                        tmp.setLength(0);
                        break;
                    }
                }
                tmp.setLength(0);
            } else {
                stack.append(c);
            }

        }
        String answer = stack.length()==0 ? "FRULA" : stack.toString();
        System.out.println(answer);
    }
}
