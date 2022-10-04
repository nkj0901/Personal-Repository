import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution8500극장좌석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 입력받는 순서대로 앉힐 필요는 없으니 최소로 값을 출력하려면 정렬을 하자
			Arrays.sort(arr);

			int ans = N; //일단 N명 앉을 자리 필요, 빈자리가 얼마나 필요한지 구해보자.
			
			// 첫번째 애의 왼쪽 오른쪽은 보고가자
			ans += arr[0] * 2;

			for (int i = 1; i < N; i++) {
				//왼쪽에 의자가 몇개 필요한지 보고 ++
				//(정렬 했으니 앞에는 무조건 나보다 숫자가 작거나 같은 애니까 의자를 추가하거나 그대로 놔둬야함)
				//오른쪽 자기만큼 ++
				ans+=Math.abs(arr[i-1]-arr[i])+arr[i];
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
//	private static void mergeSort(int[] arr, int left, int right) {
//
//		if (left >= right) { // 같아지는 것도 포함을 해야 한다.
//			return;
//		}
//		int mid = (left + right) / 2;
//		mergeSort(arr, left, mid);
//		mergeSort(arr, mid + 1, right);
//		merge(arr, left, mid, right);
//	}
//
//	private static void merge(int[] arr, int left, int mid, int right) {
//		int[] arrtmp = new int[arr.length];
//		int idx = left;
//		int L = left;
//		int R = mid + 1;
//
//		while (L <= mid && R <= right) {
//			if (arr[L] <= arr[R]) {
//				arrtmp[idx++] = arr[L++];
//			} else {
//				arrtmp[idx++] = arr[R++];
//			}
//		}
//
//		if (L <= mid) {
//			while (L <= mid) {
//				arrtmp[idx++] = arr[L++];
//			}
//		}
//
//		if (R <= right) {
//			while (R <= right) {
//				arrtmp[idx++] = arr[R++];
//			}
//		}
//
//		for (int i = left; i <= right; i++) {
//			arr[i] = arrtmp[i];
//		}
//	}

