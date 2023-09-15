import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2304창고다각형 {

    static class Node implements Comparable<Node> {
        int idx, high;
        Node (int idx, int high){
            this.idx = idx;
            this.high = high;
        }

        @Override
        public int compareTo(Node o) {
            return this.idx-o.idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        int mh = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            mh = Math.max(mh, high);
            arr[i] = new Node(idx, high);
        }

        Arrays.sort(arr);

        int maxIdx = 0;
        int preIdx = 0;
        int cur = arr[0].high;
        int answer = 0;

        for(int i = 1; i < N; i++){
            if(cur <= arr[i].high) {
                answer+=cur*(arr[i].idx-arr[preIdx].idx);
                preIdx = i;
                cur = arr[i].high;
            }

            if(arr[i].high == mh) {
                maxIdx = i;
                break;
            }
        }

        preIdx = N-1;
        cur = arr[N-1].high;
        for(int i = N-2; i >= maxIdx; i--) {
            if (cur <= arr[i].high) {
                answer += cur * (arr[preIdx].idx - arr[i].idx);
                preIdx = i;
                cur = arr[i].high;
            }
        }
        answer+=arr[maxIdx].high;
        System.out.println(answer);
    }
}
