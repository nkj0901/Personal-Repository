import java.util.Scanner;

public class Solution2027 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if(j*1==i) {
					System.out.print("#");
				} else {
					System.out.print("+");
				}
			} System.out.println("");
		}
	}
}
