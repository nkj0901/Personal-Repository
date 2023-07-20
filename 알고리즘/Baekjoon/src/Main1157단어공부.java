import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main1157단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.toUpperCase();

        int[] cnt = new int[26];

        for(int i = 0; i < str.length(); i++){
            cnt[str.charAt(i)-65]++;
        }
        char answer = 'a';
        int max = 0; //현재 제일 많이 나온 애 몇번 나온 것일까
        int count = 0; //같은 것이 몇개 나왔는지
        for(int i = 0; i < 26; i++){
            if(max < cnt[i]){
                max = cnt[i];
                answer = (char)(i+65);
                count=0;
            } else if(max == cnt[i]){
                count++;
            }
        }
        answer = count == 0 ? answer : '?';
        System.out.println(answer);
    }
}
