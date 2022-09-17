import java.util.Scanner;

public class Solution2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++ ) {
			arr[i] = sc.nextInt();			
		}
		
		for (int j = 0; j < arr.length-1; j++) {
			for (int z = 0; z < arr.length-1-j; z++) {
				if(arr[z] > arr [z+1]) {
					int tmp = arr[z];
					arr[z] = arr[z+1];
					arr[z+1] = tmp;
				}
				
			}
		}
		int d = arr.length/2;
		System.out.println(arr[d]);
	}	
}
