import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//숫자개수
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//최대값을 구하기. 배열
		//배열만들기
		int[] arr = new int[N];
		for (int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//버블정렬로 정렬
		//반복할 횟수
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < N-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					//앞칸이 더 크면 뒷칸과 바꿔줌
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		//제일 큰 값을 찾아서 나머지 점수에 /M*100을 해야한다. 그리고 다시 평균값을 구하자
		int sum = 0;
		int M = arr[N-1];
		for(int i = 0; i < N; i++) {
			sum+= arr[i]/M*100;
		}
		
		System.out.println(sum);
		
		double ans = (double)sum/N;
		
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
