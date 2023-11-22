import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            pq.offer(num1+num2);
            sum+=num1+num2;
        }

        int ans = N > 1 ? sum : 0;
        System.out.println(ans);
    }
}