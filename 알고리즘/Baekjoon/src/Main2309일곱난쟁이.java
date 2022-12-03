import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main2309일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		
		//배열에 난쟁이 키 넣기
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//모든 경우의 수 파악하기
		for(int i = 0; i < (1<<9); i++) {
			int sum = 0;
			List<Integer> list = new ArrayList<Integer>();
			//첫번째 난쟁이부터 있는지 확인
			for (int j = 0; j < 9; j++) {
				if ((i & (1<<j)) > 0) {
					sum+=arr[j];
					list.add(arr[j]);
				}
			}
			if (sum == 100 && list.size()==7) {
				Collections.sort(list);
				for (int j = 0 ; j < 7; j++) {
					bw.write(list.get(j)+"\n");
				}
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
