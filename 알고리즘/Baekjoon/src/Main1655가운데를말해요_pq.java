import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main1655가운데를말해요_pq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());
            if(minHeap.isEmpty()) minHeap.add(num);
            else if(maxHeap.isEmpty()) {
                if(minHeap.peek() > num) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            } else {
                if(maxHeap.peek() <= num) maxHeap.add(num);
                else minHeap.add(num);
            }

            int minSize = minHeap.size();
            int maxSize = maxHeap.size();

//            System.out.println(minHeap);
//            System.out.println(maxHeap);


            //minSize가 더 크면 안된다
            if(maxSize - minSize >= 1) {
                minHeap.add(maxHeap.poll());
            } else if(minSize - maxSize >= 2){
                maxHeap.add(minHeap.poll());
            }

//            System.out.println(minHeap);
//            System.out.println(maxHeap);
//            System.out.println("----------------------");
            sb.append(minHeap.peek());
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
/*
6
5
4
2
1
6
2
 */