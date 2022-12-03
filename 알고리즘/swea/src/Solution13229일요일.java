import java.util.Scanner;

public class Solution13229일요일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++ ) {
			
			System.out.print("#" + t + " ");
			switch (sc.next()) {
			case "SUN":
				System.out.println(7);
				break;
			case "SAT":
				System.out.println(1);
				break;
			case "FRI":
				System.out.println(2);
				break;
			case "THU":
				System.out.println(3);
				break;
			case "WED":
				System.out.println(4);
				break;
			case "TUE":
				System.out.println(5);
				break;
			case "MON":
				System.out.println(6);
				break;
			default:
				break;
			}
		}
	}

}
