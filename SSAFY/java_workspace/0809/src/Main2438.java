import java.util.Scanner;

public class Main2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		//5줄만들거야
		for (int i = 1; i <= n; i++) {
			//빈칸 찍을 횟수
			int j;
			for (j = 1; j <= n-i; j++) {
				System.out.print(" ");				
				}
			//*찍을 횟수
			for (int z = 1; z <= i; z++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
