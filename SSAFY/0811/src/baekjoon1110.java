import java.util.Scanner;

public class baekjoon1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int n1 = 0; // 일의 자리 수 
		int n10 = 0; // 십의 자리 수 
		
		//자리수 구하기
		if (N < 10) {
			n1 = N;
		} else {
			n1 = N % 10; 
			n10 = N / 10;
		}
		int newnb = 0;
		while(newnb != N) {			
		newnb = n1 + n10;
		
		n1 = newnb%10;
		n10 = newnb/10;
		// 구한 것에서 n1 + newnb 1일 자리를 더할 것
							
		}
		
		
	}
}
