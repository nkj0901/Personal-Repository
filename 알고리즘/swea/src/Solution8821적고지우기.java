import java.util.Scanner;

public class Solution8821적고지우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String str = sc.next();
			boolean[] arr = new boolean[10];
			
			for(int i = 0; i < str.length(); i++) {
				int num = str.charAt(i)-'0';
				if(arr[num]== true) {
					arr[num] = false;
				} else {
					arr[num] = true;
				}
			}
			int cnt = 0;
			for(int i = 0; i < 10; i++) {
				if(arr[i] == true) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
