
public class Solution3131백만이하의모든소수 {
	public static void main(String[] args) {
		
		boolean[] sosu = new boolean[1000001];
		
		for(int i = 2; i <= Math.sqrt(1000000); i++) {
			if(!sosu[i]) {
				for(int j = i; j*i <= 1000000; j++) {
					sosu[i*j] = true;
				}
			}
		}
		
		for(int i = 2; i < 1000001; i++) {
			if(sosu[i] == false)
				System.out.print(i + " ");
		}
	}
}
