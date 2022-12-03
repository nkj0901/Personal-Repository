import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int max = -1000000;
		int min = 1000000;
		// N개의 숫자만큼 숫자를 받아 배열에 넣기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		// 배열 오름차순으로 만들기
		// 1. 크기가 제일 큰 것을 구할 것
		
		int[] count = new int[max-min+1];
		 
		// 2. 배열 만들어서 카운팅하기
		for (int i = 0; i < N; i++) {
			count[arr[i]-min]++;			
		}

		// 3. 누적합구하기
		for (int i = 0; i < count.length-1; i++) {
			count[i+1]+=count[i];
		}
		
		// 4. 배열의 인덱스 -1한 값에 수를 넣기
		int[] tmp = new int[N];
		
		for (int i = N-1 ; i >= 0; i--) {
			tmp[--count[arr[i]-min]]=arr[i];
		}
		for(int a : tmp) {
		bw.write(a + "");
		bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
