import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main7490_0만들기 {
    static List<String> answer;
    static int N;
    static char[] sel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());

            sel = new char[N-1];
            dfs(1, "1");
            sb.append('\n');

        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int n, String str) {
        if( n == N ) {
            calculate(str);
            return;
        }
        dfs(n+1, str+" " + String.valueOf(n+1));
        dfs(n+1, str+"+" + String.valueOf(n+1));
        dfs(n+1, str+"-" + String.valueOf(n+1));
    }

    public static void calculate(String str){
        List<String> list = new ArrayList<>();

        int num = 0;
        for(int i = 0; i < str.length(); i++){

            if( str.charAt(i) == '+' || str.charAt(i) =='-') {
                list.add(String.valueOf(num));
                num = 0;
                list.add(String.valueOf(str.charAt(i)));
            } else if (!(str.charAt(i) == ' ')){
                num = num*10+(str.charAt(i)-'0');
            }

            if(i == str.length()-1) list.add(String.valueOf(num));
        }

        int sum = Integer.parseInt(list.get(0));
        for(int i = 1; i < list.size(); i+=2) {
            String oper = list.get(i);
            int n = Integer.parseInt(list.get(i+1));
            if(oper.equals("+")){
                sum+=n;
            } else {
                sum-=n;
            }
        }

        if(sum == 0) sb.append(str).append('\n');
    }

}
