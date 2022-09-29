import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1240 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String[] code = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001","0101111", "0111011", "0110111", "0001011"};
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(st.nextToken());
			int M  = Integer.parseInt(st.nextToken());
			int[] ans = new int[8];
			int tmp = 0;
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				char[] c = new char[7];
				for(int j = N; j >= 0; j++) {
				
					//1발견하면 발견한 곳 -7부터 잘라서 배열에 저장할거야.
					if(str.charAt(j)==1) {
						for(int z = j-7; z <=j; z++) {
							str.charAt(z);
						}
					}
					for(int a = 0; a < 10; a++) {
					for(int b = 0; b < 8; b++) {
						if(code[a].charAt(b) != c[b]) {
							continue;
						}
						//다 똑같으면 이 값을 ans 배열에 저장
						if (b == 7);
					}
					}
					break;
				}
			}
		}
	
	}
}
