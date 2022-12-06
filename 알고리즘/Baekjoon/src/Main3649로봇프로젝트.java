import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3649로봇프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			int x = Integer.parseInt(input) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			// 값을 입력받고 배열 정렬
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			//Two pointer로 쓰일 두 개의 변수
			int start = 0;
			int end = n-1;
			
			//답이 있는지 없는지 알려줄 아이
			boolean flag = true;
			
			while(true) {
				
				//시작점과 끝점이 교차하면 멈춰라... 답이 없다.
				if(start>=end) {
					flag = false;
					break;
				}
				
				int sum = arr[start] + arr[end]; 
				
				//값이 크면 end를 줄여서 값을 작게 만들어보자
				if(sum > x) {
					end--;
				} // 값이 작으면  start를 늘려서 값을 크게 만들어보자
				else if (sum < x) {
					start++;
				} // 값이 같으면 게임 끝~! 
				else {
					break;
				}
				
			}
			if(flag ) {
				System.out.println("yes " + arr[start] + " " + arr[end]);
			} else {
				System.out.println("danger");
			}
		}
	}
}
