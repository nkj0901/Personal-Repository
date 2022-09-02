import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 금은동 배열만들기
		int[] gold = new int[N + 1];
		int[] silver = new int[N + 1];
		int[] bronze = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken()); 
			gold[index] = Integer.parseInt(st.nextToken());
			silver[index] = Integer.parseInt(st.nextToken());
			bronze[index] = Integer.parseInt(st.nextToken());
		}

		// 금매달 배열 순회
		int gcnt = 0; // 나보다 금메달 많은 국가 수
		List<Integer> goldIndex = new ArrayList<>(); // 만약 같은 애가 있으면 인덱스 여기 저장
		boolean goldSame = false;
		for (int i = 1; i <= N; i++) {
			if (i != K && gold[K] < gold[i]) {
				gcnt++;
			} else if (i != K && gold[K] == gold[i]) {
				// 같은 애가 있으면 true로 바꿔 줌
				goldSame = true;
				goldIndex.add(i);
			}
		}
		
		// 골드 수 같은 게 있으면 여기서 한번 더 비교
		int scnt = 0; // 나보다 은메달 많은 국가 수
		List<Integer> silverIndex = new ArrayList<>(); // 만약 같은 애가 있으면 인덱스 여기 저장
		boolean silverSame = false;
		if (goldSame == true) {
			for (int i = 0; i < goldIndex.size(); i++) {
				if (i != K && silver[K] < silver[goldIndex.get(i)]) {
					scnt++;
				} else if (i != K && silver[K] == silver[goldIndex.get(i)]) {
					// 같은 애가 있으면 true로 바꿔 줌
					silverSame = true;
					silverIndex.add(goldIndex.get(i));
				}
			}
		}

		// 실버 수 같은 게 있으면 여기서 한번 더 비교
		int bcnt = 0; // 나보다 동메달 많은 국가 수
		if (silverSame == true) {
			for (int i = 0; i < silverIndex.size(); i++) {
				if (i != K && bronze[K] < bronze[silverIndex.get(i)]) {
					bcnt++;
				}
			}
		}

		ans = gcnt + scnt + bcnt + 1;

		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
