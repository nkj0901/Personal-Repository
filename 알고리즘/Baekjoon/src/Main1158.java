import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//배열만들기
		int[] arr = new int[N];
		int[] arr1 = new int[N]; //없어지는 순서
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		int x = 0;
		int cnt = 0;
		int size = N; //남아있는 병사 수
		while (size > 0) {
			
			if (arr[x%N] == 1) {
				cnt++;
				}
			
			if (cnt == K) {
				arr1[arr.length-size]=x%N+1;
				arr[x%N] = -1;
				cnt = 0;
				size--;
			}
			x++;
		}
		
		bw.write("<");
		for (int z = 0; z < arr1.length-1; z++) {
			bw.write(arr1[z] + ", ");
		}
		bw.write(arr1[N-1] + ">");
		bw.flush();
		br.close();
		bw.close();
	}
}
