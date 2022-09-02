import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//KBS1찾아서 걔가 있는 위치에 커서 옮기고 0번 인덱스로 옮김(진짜로 옮기는 게 아님)
		//배열이 있다고 생각하는거지 배열을 진짜 만드는 게 아니다
		//KBS1과 KBS2의 인덱스를 저장해서 둘이 비교해 줄 것.
		//누가 먼저 나오냐에 따라  KBS2의 이동 횟수가 달라지기 때문
		int kbs1Index = 0;
		int kbs2Index = 0;
		for (int n = 0; n < N; n++) {
			String c = br.readLine();
			if (c.equals("KBS1")) {
				kbs1Index = n;
				//인덱스 만큼 커서 아래로 이동
				for (int i = 0; i < n; i++) {
					bw.write(1+"");
				}
				//인덱스 만큼 위로 올림
				for (int i = 0; i < n; i++) {
					bw.write(4+"");
				}
			}
			if (c.equals("KBS2")) {
				kbs2Index = n; 
			}
		}
		
		//kbs2가 더 먼저나오면 인덱스 + 1만큼 화살표 아래로 이동
		//인덱스 만큼 위로 올림
		if (kbs1Index > kbs2Index) {
			for (int i = 0 ; i < kbs2Index +1; i++) {
				bw.write(1+"");
			}
			for (int i = 0; i < kbs2Index; i++) {
				bw.write(4+"");
			}
		} 
		//kbs1이 더 많이 나오면 인덱스 만큼 아래로 이동
		//인덱스 -1만큼 위로 올림
		else {
			for (int i = 0; i < kbs2Index; i++) {
				bw.write(1+"");
			}
			for (int i = 0; i < kbs2Index-1; i++) {
				bw.write(4+"");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
