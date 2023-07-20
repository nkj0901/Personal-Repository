import java.io.*;
import java.util.StringTokenizer;

public class Main1244스위치키고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] check = new int[N];
        for(int i = 0; i < N; i++){
            check[i]=Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());

        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            //남자라면
            if(Integer.parseInt(st.nextToken()) == 1){
                int num = Integer.parseInt(st.nextToken());
                //배수이면 상태 변경해주기
                for(int j = 0; j < N; j++){
                    if((j+1)%num == 0) check[j]^=1;
                }
            }
            //여자라면
            else{
                int num = Integer.parseInt(st.nextToken())-1;
                check[num]^=1;
                for(int j = 1; num-j >= 0 && num+j < N; j++){
                    if(check[num-j] == (check[num+j])) {
                        check[num-j]^=1;
                        check[num+j]^=1;
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
           bw.write(check[i]+" ");
            if((i+1)%20 == 0) bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
