import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution10570제곱팰린드롬수 {
	
	//팰린드롬인지 확인하는 함수
	public static boolean func(double num) {
		if (num != (int)num) return false; //제급근이 소수이지 확인 아닐 때만 판별
		String str = (int)num+"";
		for (int i = 0; i < str.length()/2; i++) {
			if (str.charAt(0) != str.charAt(str.length()-i-1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for (int i = A; i <= B; i++) {
				//숫자와 숫자제곱근 둘다 팰린드롬일 때 cnt++
				if (func(i)==true && func(Math.sqrt(i))==true) {
					cnt++;
				}
			}
			bw.write("#" + t + " " + cnt + "\n");
		} //tc
		bw.flush();
		br.close();
		bw.close();
	}
}
