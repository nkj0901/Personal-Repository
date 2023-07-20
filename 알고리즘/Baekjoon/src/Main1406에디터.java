import java.io.*;
import java.util.*;

public class Main1406에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();

        //커서 맨뒤로 옮겨주기
        while(iter.hasNext()) iter.next();

        for(int i = 0; i < N; i++) {
            String com = br.readLine();
            char c = com.charAt(0);

            if( c == 'P'){
                char t = com.charAt(2);
                iter.add(t);
            } else if( c == 'L'){
                if(iter.hasPrevious()) iter.previous();
            } else if( c == 'D'){
                if(iter.hasNext()) iter.next();
            } else {
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }
        }
        for(Character ch : list){
            bw.write(ch);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
