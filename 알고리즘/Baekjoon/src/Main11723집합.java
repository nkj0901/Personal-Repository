import java.io.*;
import java.util.StringTokenizer;

public class Main11723집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int num = 0;
        int check = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    check = check | (1 << (num -1));
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    check = check & ~(1 << (num-1));
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    if((check & ~(1 << (num-1))) == check) bw.write("0\n");
                    else bw.write("1\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    check = check ^ (1 << num-1);
                    break;
                case "all" :
                    check = check | (~0);
                    break;
                case "empty" :
                    check = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
