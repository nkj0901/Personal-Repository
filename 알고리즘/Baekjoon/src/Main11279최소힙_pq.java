import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main11279최소힙_pq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            if( n == 0 ){
                if(pq.size() == 0) {
                    bw.write(0+"\n");
                    continue;
                }
                bw.write(pq.remove()+"\n");
            } else {
                pq.add(n);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
