
	import java.util.Scanner;

	public class 블랙잭 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int M = sc.nextInt();
	        int[] arr = new int[N];
	        for (int i = 0; i < N; i++) {
	            arr[i] = sc.nextInt();
	        }
	        int sum = 0;
	        int minus = 0;
	        int mini = 999999999;
	        int ans = 0;
	        for (int i = 0; i < N; i++) {
	            for (int j = i + 1; j < N; j++) {
	                for (int k = j + 1; k < N; k++) { // 숫자 세개를 모두 불러와서
	                    sum = (arr[i] + arr[j] + arr[k]); // 더한 값이
	                    if (M >= sum) { // M보다 작거나같으면
	                        minus = M - sum; // 차이를 구해 저장
	                        if (mini > minus) { // 이 차이가 기존 값보다 작으면
	                            mini = minus; // 갱신
	                            ans = sum; // 답에 합 저장
	                        } else
	                            continue;
	                    } else
	                        continue;
	                }
	            }

	    }
	    System.out.println(ans);
	    sc.close();
	}
	}

