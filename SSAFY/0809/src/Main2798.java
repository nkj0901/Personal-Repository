import java.util.Scanner;

public class Main2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//베열만들기
		int[] arr = new int[N];
		for (int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 완전 검색
		int min = M;//가장 작은 차이 값
		int minnum = 0;//제일 적게 차이가 났던 수를 저장기 위한 값
		int sum = 0;//abc 합한 값
		for (int a = 0; a < N-2; a++){
			for (int b = a+1; b <= N-2; b++ ) {
				for (int c = b+1; c <= N-1; c++) {
					sum = arr[a] + arr[b] + arr[c];
					if (sum <= M) {
						int m = 0;
						m = M-sum;
						if(m <= min) {
							min = m;
							minnum = sum;							
						}
					}
				}
			}
		}
		System.out.println(minnum);
	}//main
}
