import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int max = 0; //제일 높은 애 높이 저장할 변수
        int maxIndex = 0; //제일 높은 애 인덱스
        int sum = 0;
        int i = 0;
        while (start < W-2) {
            for (i = start + 1; i < W; i++) {
                if (arr[start] > arr[i]) {
                    if (max < arr[i]) {
                        max = arr[i];
                        maxIndex = i;
                    }
                } else {
                    max = arr[i];
                    maxIndex = i;
                    break;
                }
            }
            if (max >= arr[start]) {
                for (int j = start + 1; j < maxIndex; j++) {
                    sum += arr[start] - arr[j];
                }
            } else {
                for (int j = start + 1; j < maxIndex; j++) {
                    sum += arr[maxIndex] - arr[j];
                }
            }
                start = maxIndex;
                max = 0;
        }
            System.out.println(sum);
    }
}
