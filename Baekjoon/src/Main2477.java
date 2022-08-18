import java.io.IOException;
import java.util.Scanner;

public class Main2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		// 1제곱당 열리는 참외 개수
		int K = sc.nextInt();
		int[] dir = new int[6];
		int[] s = new int[6];
		
		int wmax = 0;
		int hmax = 0;
		//방향과 길이를 받고 배열에 넣는다. 큰 사각형을 구할 가로 세로 크기를 구한다.
		for (int i = 0; i < 6; i++) {

			int direction = sc.nextInt();
			int side = sc.nextInt();
			
			dir[i] = direction;
			s[i] = side;
			
			if(direction == 3 || direction == 4) {
				if (wmax < side) {
					wmax = side;
				}
			} else if (direction == 1 || direction == 2) {
				if (hmax < side) {
					hmax = side;
				}
			}
		}
		
		// 3-> 2 or 1 -> 3 or 4 -> 1 or 2 -> 4일 때 마이너스
		int smallsquare = 0; //큰 사각형에서 뺄 작은 사각형의 크기
		for(int i =0; i < dir.length-1; i++) {
			int t = dir[i], t1 = dir[i+1];
			if (t==3&&t1==2 || t==1&&t1==3 || t==4&&t1==1 || t==2&&t1==4) {
				smallsquare=s[i]*s[i+1];
			}
		}
		
		//큰 사각형에서 작은 사각형을 뺀다.
		int bigsquare = wmax*hmax;
		int extend = bigsquare-smallsquare;
		
		System.out.println(extend*K);
	}
}
