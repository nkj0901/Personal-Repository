import java.util.Scanner;

public class Solution4831전기버스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			int K = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N+1];
			
			//처음 충전소가 있는 곳
			int idx = sc.nextInt();
			
			//다음충전기가 있는 곳을 저장해줌
			for(int i = 0; i < M-1; i++) {
				arr[idx] = sc.nextInt();
				idx = arr[idx];
			}
			
			//마지막 정류장에는 도착지를 넣어준다.
			arr[idx] = N;
			
			int cnt = 0;
			int k = K;
			boolean flag = true;
			
			for(int i = 1; i < N; i++) {
				k--;
				
				//연료 0인데 충전소가 없어 그럼 답은 0
				if(k == 0 && arr[i] == 0) {
					flag = false;
					break;
				}
				
				//충전기가 있는 곳에 도착했는데 지금 남아있는 k보다 다음 충전소가 있는 거리가 더 크면 충전해야 함
				if(arr[i] != 0 && k <arr[i]-i) {
					cnt++;
					k=K;
				}
			}
			int ans = 0;
			if(flag == false) ans = 0;
			else ans = cnt;
			System.out.println("#" + t + " " + ans);
		}
	}
}
