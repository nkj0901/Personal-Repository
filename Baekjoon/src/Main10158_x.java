import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10158_x {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st1.nextToken());
		int y = Integer.parseInt(st1.nextToken());

		int t = Integer.parseInt(br.readLine());

		// t만큼 이동시킬건데 x나 y가 w나 y라면 x-1, y+1해준다.
		// 처음은 오른쪽으로 이동 ++
		// 다음은 왼쪽으로 이동 --
		int dir = 1;
		for (int i = 0; i < t; i++) {
			// 끝을 만나면 방향을 바꿔줌
			if (x == 0 || x == w || y == 0 || y == h) {
				// x-1, y+1할 수 없는 경우가 있음
				// 이때는 둘다 ++하거나 --하거나
				if (y == h) {
					x -= 1;
					y -= 1;
				} else if (x == 0) {
					x += 1;
					y += 1;
				} else {
					x -= 1;
					y += 1;
					while (x != 0 && x != w && y != 0 && y != h) {
						x -= 1;
						y += 1;
						i++;
					}
				}
				// 만약 방향을 바꿨는데도 둘중하나가 0인 경우
				// 이렇게 안해주면 또 방향을 바꿔주게 되기 때문에 여기서 실행
				if (t < t - 1 && x == 0 || x == w || y == 0 || y == h) {
					x += (-dir);
					y += (-dir);
					// 여기서 1시간 더 간거니까 i++
					i++;
				} // 방향 바꿔주기
				dir *= -1;
			} else {
				x += dir;
				y += dir;
			}
		}
		bw.write(x + " " + y);
		bw.flush();
		br.close();
		bw.close();
	}
}
