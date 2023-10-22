import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2179비슷한단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(i, br.readLine());
        }

        Arrays.sort(arr);
        Node answer1 = arr[0];
        Node answer2 = arr[1];

        int same = 0;
        for (int i = 0; i < N - 1; i++) {
            Node cur = arr[i];
            for (int j = i + 1; j < N; j++) {
                Node next = arr[j];

                int cnt = 0;
                int index = 0;
                while(index < cur.str.length()){
                    if (cur.str.charAt(index) != next.str.charAt(index)) break;
                    cnt++; index++;
                }

                if (cur.idx > next.idx) {
                    Node tmp = cur;
                    cur = next;
                    next = tmp;
                }

                if (cnt > same) {
                    answer1 = cur;
                    answer2 = next;
                    same = cnt;
                } else if (cnt == same) {
                   if (answer1.idx > cur.idx) {
                        answer1 = cur;
                        answer2 = next;
                    } else if (answer1.equals(cur)) {
                        if (answer2.idx > next.idx) answer2 = next;
                    }
                }
            }
        }
        System.out.println(answer1.str);
        System.out.println(answer2.str);
    }

    static class Node implements Comparable<Node> {
        int idx;
        String str;

        Node(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }

        @Override
        public int compareTo(Node o) {
            return str.compareTo(o.str);
        }
    }
}
/*10
abcd
abcdefg
abbbeeee
abc
abcdef
abce
abcdfew
avcdf
ab
abcdewgh*/
