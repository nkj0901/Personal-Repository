import java.util.Arrays;
import java.util.Scanner;

public class Main2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 배열만들기
		int[] arr = new int[9];
		int sum = 0; // 아홉명의 난쟁이 키의 합
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		// -2해서 100이 되는 경우 출력하기
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					Arrays.sort(arr);
					for (int x = 2; x < arr.length; x++) {
						System.out.println(arr[x]);
					}
					return;
				}
			}
		}
	}
}
