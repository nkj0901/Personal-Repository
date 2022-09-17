import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//배열 개수만큼 돌려서 배열 채우기
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
		}
		
		int max = -1000000;
		int min = 1000000;
		
		for (int i = 0; i < N; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		
		bw.write(min + " " + max+ "");
		bw.flush();
		br.close();
		bw.close();
	}
}
