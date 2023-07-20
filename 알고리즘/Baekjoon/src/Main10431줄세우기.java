import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main10431줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int answer = 0;

            int[] arr = new int[20];
            for(int j = 0; j < 20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int a = 1 ; a < 20; a++) {
                    int tmp = arr[a];
                for(int b = 0; b < a; b++) {
                    if(arr[b] > arr[a]) {

                        for(int c = a; c > b; c--){
                            arr[c] = arr[c-1];
                            answer++;
                        }
                        arr[b] = tmp;
                        break;
                    }
                }
            }
            System.out.println(tc + " " + answer);
        }
    }
}
