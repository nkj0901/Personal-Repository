import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * 3가지 경우의 수를 볼 것 (이미 꽂혀있으면 아무것도 하지 않고 지나간다) 1. 멀티탭이 비어있는 경우 2. 멀티탭에 자리가 없지만
 * 꽂혀있는 애중에 나중에 쓰이지 않는 애가 있는 경우 3. 멀티탭에 자리가 없고 다 나중에 쓰이는 아이들일 경우
 */

public class Main1700멀티탭스케줄링 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
		int K = Integer.parseInt(st.nextToken()); // 사용순서
		int[] arr = new int[K]; // 사용순서

		boolean[] check = new boolean[100 + 1]; // 해당 숫자의 전자제품이 꽂혀있는지 아닌지 확인

		// 배열채우기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		int soket = 0;
		for (int i = 0; i < K; i++) {
			int tmp = arr[i];
			if (check[tmp]) //이미 꽂혀있으면 지나가
				continue;
			if (soket < N) {//멀티탭에 공간이 있는 경우
				check[tmp]= true; //지금 꽂혀있다.
				soket++;
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j = i; j < K; j++) {
					// 꽂혀있고 아직 list에 들어가지 않은 애들은 들어가라
					if(check[arr[j]] && !list.contains(arr[j])) {
						list.add(arr[j]);
					}
				}
				
				//앞으로 더 꽂혀야 하는 얘들이 N보다 작으면
				//뒤에 안나오는 애 
				if(list.size() != N) {
					for(int j = 0; j < 101; j++) {
						if(check[j] && !list.contains(j)) {
							check[j] = false;
							break;
						}
					}
				} else { 
					int remove = list.get(list.size() - 1);
					check[remove] = false;
				}
				check[tmp] = true;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
