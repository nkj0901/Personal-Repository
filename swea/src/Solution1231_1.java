import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1231_1 {

	static String[] arr;
	static int N;

	static void inorder(int i) {
		if (i > N)
			return;
		inorder(i*2);
		inorder(i*2+1);	
		System.out.print(arr[i]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new String[N * 2 + 1];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				arr[i] = st.nextToken();
			}

			System.out.print("#" + t + " ");
			inorder(1);
			System.out.println();
		}
	}

}
