import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1253좋다_투포인터 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//배열채우기
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		int ans = 0;
		//N개의 아이들을 모두 보겠다
		for(int i = 0; i < N; i++) {
		
			int start = 0;
			int end = N-1;
		
			while(start < end) {
				
				if(start == i)start++;
				if(end == i)end--;
				
				if(start == end) break;
				
				if( arr[start] + arr[end] < arr[i]) start++;
				else if( arr[start] + arr[end] > arr[i] ) end--;
				else {
//					System.out.println(arr[start] + " " + arr[end] + " " + "합하면 : " + arr[i]);
					ans++; break; 
				}
			}
		}
		System.out.println(ans);
	}
}
